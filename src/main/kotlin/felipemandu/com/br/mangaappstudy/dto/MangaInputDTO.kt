package felipemandu.com.br.mangaappstudy.dto

class MangaInputDTO(
    val title: String,
    val release: String? = null,
    val rating: Int? = null,
    val description: String? = null,
    val status: String? = "ONGOING",
    val authors: Set<String>? = null,
    val genres: Set<String>? = null,
    val originCountry: String? = null,
    val originLanguage: String? = null,
    val translatedLanguage: String,
)