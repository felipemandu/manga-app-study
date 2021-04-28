package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Chapter
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.Optional

@Repository
interface ChapterRepository : JpaRepository<Chapter, Long> {
    fun findByTitleLike(title: String): Optional<Chapter>
    fun findByNumberAndManga_Id(number: Int, id: Long): Optional<Chapter>
    fun findByManga_id(id: Long, page: Pageable): Page<Chapter>
    fun findByISBN(isbn: String): Optional<Chapter>
    fun findByRelease(date: Date, page: Pageable): Page<Chapter>
}