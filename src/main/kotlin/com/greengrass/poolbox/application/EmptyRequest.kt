package com.greengrass.poolbox.application

class EmptyRequest private constructor() {
    companion object {
        val instance = EmptyRequest()
    }
}