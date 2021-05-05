package felipemandu.com.br.mangaappstudy.dto

data class ChapterDTO(
    val title: String? = null,
    val chapterNumber: Int,
    val numberPages: Int? = null,
    val ISBN: String? = null,
    val release: String? = null,
    val pages: Set<String>? = null,
    val idManga: Long
)


