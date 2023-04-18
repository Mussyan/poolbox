package com.greengrass.poolbox.application

import org.slf4j.LoggerFactory
import java.util.*
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation

class User(
    val id: String,
    val token: String?
) {
    private val traceId: String = UUID.randomUUID().toString()

    override fun toString(): String {
        return "id : $id \ntrace id : $traceId"
    }

    fun <Request, Response> requestTo(useCase: UseCase<Request, Response>): UseCaseHolder<Request, Response> {
        return UseCaseHolder(this, useCase)
    }

    interface UseCaseExecutor<Request, Response> {
        fun execute(): Response

        operator fun invoke(): Response {
            return execute()
        }
    }

    class UseCaseHolder<Request, Response>(
        private val user: User,
        private val useCase: UseCase<Request, Response>
    ) : UseCaseExecutor<Request, Response> {
        private val logger = LoggerFactory.getLogger(UseCase::class.java)
        private var _request: Request? = null
        var request: Request?
            get() {
                return _request
            }
            private set(value) {
                _request = value
            }

        fun by(request: Request): UseCaseExecutor<Request, Response> {
            this.request = request
            return this
        }

        private val validator = Validation.buildDefaultValidatorFactory().validator

        override fun execute(): Response {
            if (request == null) {
                @Suppress("UNCHECKED_CAST")
                request = EmptyRequest.instance as? Request ?: throw Exception()
            }
            logger.info("${user.id} start ${useCase.name} usecase\nThread ID - ${Thread.currentThread().id}")
            val violations = validator.validate(request!!)
            if (violations.isNotEmpty()) {
                throw ConstraintViolationException(violations)
            }

            val result = try {
                useCase.execute(user, request!!)
            } catch (ex: Exception) {
                logger.error("error $user-${useCase.name}")
                logger.error(ex.message)
                throw ex
            }

            try {
                val processorList = ProcessorProvider.processors
                processorList.forEach {
                    try {
                        logger.info("${user.id} start ${useCase.name} processor\nThread ID - ${Thread.currentThread().id}")

                        it(user, useCase.name, request!!, result)

                        logger.info("${user.id} end ${useCase.name} processor")
                    } catch (ex: Exception) {
                        println("ex - $ex")
                        logger.info("error processor $user-${useCase.name}")
                    }
                }
            } catch (ex: Exception) {
                logger.info("error processor search $user-${useCase.name}")
            }

            logger.info("${user.id} end ${useCase.name} usecase")

            return result
        }
    }
}