package felipemandu.com.br.mangaappstudy.controller

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResponseWrapper<DTO>(
    val resource: DTO? = null,
    val resources: List<DTO>? = null,
    val page: Int? = null,
    val size: Int? = null,
    val numberOfPages: Int? = null,
    val error: Error? = null
)

