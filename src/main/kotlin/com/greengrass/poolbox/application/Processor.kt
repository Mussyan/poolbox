package com.greengrass.poolbox.application

interface Processor<Request> : ProcessorBase {
    fun execute(user: User, eventName: String, request: Any, response: Any?)

    override operator fun invoke(user: User, eventName: String, request: Any, response: Any?) {
        execute(user, eventName, request, response)
    }
}
