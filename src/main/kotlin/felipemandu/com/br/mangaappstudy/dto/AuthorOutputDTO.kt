package felipemandu.com.br.mangaappstudy.dto

class AuthorOutputDTO(
    val id: Long,
    val name: String,
    val country: String,
    val mangas: List<String>
)