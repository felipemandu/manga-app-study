package felipemandu.com.br.mangaappstudy.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthorInputDTO(
    @NotBlank
    @Size(min = 2, max = 255)
    val name: String,
    val countryId: Long? = null,
)