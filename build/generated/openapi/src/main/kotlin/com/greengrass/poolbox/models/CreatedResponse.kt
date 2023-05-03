package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.greengrass.poolbox.models.Link

/**
 * 리소스 생성 성공
 * @param id 
 * @param createdAt 
 * @param links 
 */
data class CreatedResponse(

    @get:JsonProperty("id") val id: kotlin.String? = null,

    @get:JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

