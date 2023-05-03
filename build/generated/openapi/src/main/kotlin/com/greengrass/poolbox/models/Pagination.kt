package com.greengrass.poolbox.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 페이징 정보
 * @param pageSize 요청한 페이지 크기
 * @param totalCount 총 아이템 갯수
 * @param nextCursor 해당 결과 목록의 마지막 아이템 식별자. 다음 목록 요청시 cursor parameter에 넘기면 해당 값을 기준으로 다음 목록을 구성.
 */
data class Pagination(

    @get:JsonProperty("pageSize") val pageSize: kotlin.Int? = null,

    @get:JsonProperty("totalCount") val totalCount: kotlin.Long? = null,

    @get:JsonProperty("nextCursor") val nextCursor: kotlin.String? = null
) {

}

