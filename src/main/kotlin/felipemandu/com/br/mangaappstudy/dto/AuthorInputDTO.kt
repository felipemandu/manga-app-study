package felipemandu.com.br.mangaappstudy.dto

data class AuthorInputDTO(
    val name: String,
    val countryId: Long? = null,
)