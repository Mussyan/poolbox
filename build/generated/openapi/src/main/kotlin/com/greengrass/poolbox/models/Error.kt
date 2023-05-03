package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param code 
 * @param message 
 */
data class Error(

    @get:JsonProperty("code") val code: kotlin.String? = null,

    @get:JsonProperty("message") val message: kotlin.String? = null
) {

}

