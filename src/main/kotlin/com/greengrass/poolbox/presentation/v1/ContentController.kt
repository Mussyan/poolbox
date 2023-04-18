package com.greengrass.poolbox.presentation.v1

import com.greengrass.poolbox.models.Content
import com.greengrass.poolbox.models.ContentList
import com.greengrass.poolbox.models.ContentType
import com.greengrass.poolbox.operations.ContentApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ContentController : ContentApi {
    override fun getContent(authorization: String, id: String): ResponseEntity<Content> {
        return super.getContent(authorization, id)
    }

    override fun listContents(
        authorization: String,
        page: Int,
        size: Int,
        cursor: String?,
        type: ContentType?,
        sorts: List<String>?
    ): ResponseEntity<ContentList> {
        return super.listContents(authorization, page, size, cursor, type, sorts)
    }
}
