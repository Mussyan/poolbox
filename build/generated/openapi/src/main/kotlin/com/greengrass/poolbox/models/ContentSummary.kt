package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * User ID
 * @param id Content id
 * @param title Title
 * @param thumbnail Thumbnail
 */
data class ContentSummary(

    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @get:JsonProperty("thumbnail", required = true) val thumbnail: kotlin.String
) {

}

