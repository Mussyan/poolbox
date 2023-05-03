package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.greengrass.poolbox.models.Link

/**
 * 공통 항목
 * @param links 관련 링크
 */
data class Root(

    @get:JsonProperty("links") val links: kotlin.collections.List<Link>? = null
) {

}

