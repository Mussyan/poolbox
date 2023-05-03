package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * User ID
 * @param id 
 */
data class UserId(

    @get:JsonProperty("id", required = true) val id: kotlin.String
) {

}

