package com.greengrass.poolbox.presentation

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("\${server.error.path:\${error.path:/error}}")
class GlobalErrorController(
    val errorAttributes: ErrorAttributes
) : AbstractErrorController(errorAttributes) {

    @RequestMapping
    fun error(request: HttpServletRequest?): ResponseEntity<Map<String?, Any?>?>? {
        var status = getStatus(request!!)
        if (status == HttpStatus.NO_CONTENT) {
            return ResponseEntity(status)
        }
        val body = getErrorAttributes(request, getErrorAttributeOptions())
        if(body.containsKey("status")) {
            val statusInBody = body["status"]
            if (statusInBody is HttpStatus)
                status = statusInBody
        }
        return ResponseEntity(body, status!!)
    }

    private fun getErrorAttributeOptions(): ErrorAttributeOptions? {
        var options = ErrorAttributeOptions.defaults()
        options = options
            .including(ErrorAttributeOptions.Include.EXCEPTION)
//            .including(ErrorAttributeOptions.Include.STACK_TRACE)
//            .including(ErrorAttributeOptions.Include.MESSAGE)
//            .including(ErrorAttributeOptions.Include.BINDING_ERRORS)
        return options
    }
}