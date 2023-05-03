package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.greengrass.poolbox.models.ContentType

/**
 * Content
 * @param id Content id
 * @param title Title
 * @param thumbnail Thumbnail
 * @param originalTitle Original title
 * @param genre Genre
 * @param creator Creator
 * @param releasedAt Released at
 * @param type 
 * @param description Content description
 */
data class Content(

    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @get:JsonProperty("thumbnail", required = true) val thumbnail: kotlin.String,

    @get:JsonProperty("originalTitle", required = true) val originalTitle: kotlin.String,

    @get:JsonProperty("genre", required = true) val genre: kotlin.collections.List<kotlin.String>,

    @get:JsonProperty("creator", required = true) val creator: kotlin.String,

    @get:JsonProperty("releasedAt", required = true) val releasedAt: kotlin.String,

    @get:JsonProperty("type", required = true) val type: ContentType,

    @get:JsonProperty("description") val description: kotlin.String? = null
) {

}

