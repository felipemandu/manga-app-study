package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChapterRepository : JpaRepository<Chapter, Long> {
}