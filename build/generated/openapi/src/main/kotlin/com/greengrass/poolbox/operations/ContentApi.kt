/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package com.greengrass.poolbox.operations

import com.greengrass.poolbox.models.Content
import com.greengrass.poolbox.models.ContentList
import com.greengrass.poolbox.models.ContentType
import com.greengrass.poolbox.models.Error
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired


import kotlin.collections.List
import kotlin.collections.Map

@RequestMapping("\${api.base-path:/v1}")
interface ContentApi {


    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/contents/{id}"],
            produces = ["application/json"]
    )
    fun getContent( @RequestHeader(value = "Authorization", required = true) authorization: kotlin.String, @PathVariable("id") id: kotlin.String): ResponseEntity<Content> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/contents"],
            produces = ["application/json"]
    )
    fun listContents( @RequestHeader(value = "Authorization", required = true) authorization: kotlin.String, @RequestParam(value = "page", required = false, defaultValue = "0") page: kotlin.Int, @RequestParam(value = "size", required = false, defaultValue = "20") size: kotlin.Int, @RequestParam(value = "cursor", required = false) cursor: kotlin.String?, @RequestParam(value = "type", required = false) type: ContentType?, @RequestParam(value = "sorts", required = false) sorts: kotlin.collections.List<kotlin.String>?): ResponseEntity<ContentList> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
