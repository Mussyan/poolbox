package com.greengrass.poolbox.presentation

import org.springframework.stereotype.Component
import com.greengrass.poolbox.common.Error

@Component
class GlobalErrorAttributes : GlobalErrorAttributesBase() {
    override fun convert(errors: List<Error>): Any {
        return errors
    }
}
