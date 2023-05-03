package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonProperty

/**
* HTTP Methods
* Values: GET,POST,PUT,PATCH,DELETE
*/
enum class LinkMethod(val value: kotlin.String) {

    @JsonProperty("GET") GET("GET"),
    @JsonProperty("POST") POST("POST"),
    @JsonProperty("PUT") PUT("PUT"),
    @JsonProperty("PATCH") PATCH("PATCH"),
    @JsonProperty("DELETE") DELETE("DELETE")
}

