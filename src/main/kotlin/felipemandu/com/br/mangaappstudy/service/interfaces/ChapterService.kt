package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.ChapterDTO
import felipemandu.com.br.mangaappstudy.entity.Chapter
import org.springframework.data.domain.Pageable
import java.util.Date

interface ChapterService : Service<ChapterDTO, Chapter> {

    fun findByTitle(title: String): Chapter
    fun findByMangaIdAndChapterNumber(id: Long, number: Int): Chapter
    fun findByMangaId(id: Long, page: Pageable): List<Chapter>
    fun findByISBN(isbn: String): Chapter
    fun findByRelease(date: Date, page: Pageable): List<Chapter>

}