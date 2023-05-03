package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

/**
 * User 정보
 * @param id User ID
 * @param externalId External ID
 * @param name Name
 * @param username Username
 * @param email User email
 * @param status 
 */
data class User(

    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:JsonProperty("externalId") val externalId: kotlin.String? = null,

    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:JsonProperty("username") val username: kotlin.String? = null,

    @get:JsonProperty("email") val email: kotlin.String? = null,

    @get:JsonProperty("status") val status: User.Status? = null
) {

    /**
    * 
    * Values: ACTIVE,INACTIVE,INVITED
    */
    enum class Status(val value: kotlin.String) {

        @JsonProperty("ACTIVE") ACTIVE("ACTIVE"),
        @JsonProperty("INACTIVE") INACTIVE("INACTIVE"),
        @JsonProperty("INVITED") INVITED("INVITED")
    }

}

