package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.greengrass.poolbox.models.Link

/**
 * 리소스 삭제 성공
 * @param id 
 * @param deletedAt 
 * @param links 
 */
data class DeletedResponse(

    @get:JsonProperty("id") val id: kotlin.String? = null,

    @get:JsonProperty("deletedAt") val deletedAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

