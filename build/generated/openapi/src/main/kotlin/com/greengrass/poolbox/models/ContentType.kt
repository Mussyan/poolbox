package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonProperty

/**
* 
* Values: MOVIE
*/
enum class ContentType(val value: kotlin.String) {

    @JsonProperty("MOVIE") MOVIE("MOVIE")
}

