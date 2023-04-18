package com.greengrass.poolbox.presentation

import com.greengrass.poolbox.common.Error
import com.greengrass.poolbox.common.HttpErrorMessage
import org.slf4j.LoggerFactory
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.http.HttpStatus
import org.springframework.web.bind.ServletRequestBindingException
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.collections.LinkedHashMap

abstract class GlobalErrorAttributesBase : DefaultErrorAttributes() {
    abstract fun convert(errors: List<Error>): Any

    override fun getErrorAttributes(
        request: WebRequest?,
        options: ErrorAttributeOptions?
    ): MutableMap<String, Any>? {
        val logger = LoggerFactory.getLogger(GlobalErrorAttributes::class.java)
        val errorAttributes: MutableMap<String, Any> = LinkedHashMap()
        val throwable: Throwable = getError(request)
        throwable.message?.let {
            logger.error(throwable.message)
        }

        errorAttributes["timestamp"] = Date()

        if (throwable is HttpErrorMessage) {
            val ex = getError(request) as HttpErrorMessage
            errorAttributes["status"] = HttpStatus.valueOf(ex.httpStatus)
            errorAttributes["items"] = convert(ex.errors)
            return errorAttributes
        }

        if (throwable is ResponseStatusException) {
            val ex = getError(request) as ResponseStatusException
            errorAttributes["status"] = ex.statusCode
            errorAttributes["items"] = convert(
                listOf(
                    Error(
                        code = "H_${ex.statusCode}",
                        message = ex.message
                    )
                )
            )
            return errorAttributes
        }

        if (throwable is ServletRequestBindingException) {
            errorAttributes["items"] = convert(
                listOf(
                    Error(
                        code = HttpStatus.BAD_REQUEST.name,
                        message = throwable.message ?: ""
                    )
                )
            )
            return errorAttributes
        }

        return errorAttributes
    }
}