package com.greengrass.poolbox.domain.useCases

import com.greengrass.poolbox.application.UseCase
import com.greengrass.poolbox.domain.models.Content

interface GetContent : UseCase<GetContent.Request, Content?> {
    companion object {
        private var storedName: String? = null
    }

    override val name: String
        get() = (storedName ?: super.name).also { storedName = it }

    data class Request(
        val content: ContentId
    )
}