package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.greengrass.poolbox.models.Link

/**
 * 리소스 수정 성공
 * @param id 
 * @param updatedAt 
 * @param links 
 */
data class UpdatedResponse(

    @get:JsonProperty("id") val id: kotlin.String? = null,

    @get:JsonProperty("updatedAt") val updatedAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

