package com.greengrass.poolbox.common

interface HttpErrorMessage {
    val httpStatus: Int
    val errors: List<Error>
}