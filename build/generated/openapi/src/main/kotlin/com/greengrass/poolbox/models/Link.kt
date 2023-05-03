package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.greengrass.poolbox.models.LinkMethod

/**
 * Link
 * @param href 
 * @param rel 
 * @param method 
 */
data class Link(

    @get:JsonProperty("href") val href: kotlin.String? = null,

    @get:JsonProperty("rel") val rel: kotlin.String? = null,

    @get:JsonProperty("method") val method: LinkMethod? = null
) {

}

