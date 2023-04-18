package com.greengrass.poolbox.application

interface ProcessorBase {
    operator fun invoke(user: User, eventName: String, request: Any, response: Any?)
}