package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * HTTP Endpoint
 * @param url url
 * @param method HTTP Methods(GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS, CONNECT)
 * @param headers HTTP Header list
 * @param body Body
 */
data class HttpEndpoint(

    @get:JsonProperty("url") val url: kotlin.String? = null,

    @get:JsonProperty("method") val method: kotlin.String? = null,

    @get:JsonProperty("headers") val headers: kotlin.collections.List<kotlin.Any>? = null,

    @get:JsonProperty("body") val body: kotlin.Any? = null
) {

}

