package felipemandu.com.br.mangaappstudy.dto

data class CountryDTO(
    val name: String,
    val spokenLanguage: Set<String>? = null
)