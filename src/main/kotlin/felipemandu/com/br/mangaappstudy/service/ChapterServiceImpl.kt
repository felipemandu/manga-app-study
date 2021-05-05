package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Chapter
import felipemandu.com.br.mangaappstudy.mapper.ChapterMapper
import felipemandu.com.br.mangaappstudy.repository.ChapterRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.ChapterService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ChapterServiceImpl(
    override val repository: ChapterRepository,
    override val to: ChapterMapper
) : ChapterService {

    override fun findByTitle(title: String): Chapter {
        return repository.findByTitleLike(title).get()
    }

    override fun findByMangaIdAndChapterNumber(id: Long, number: Int): Chapter {
        return repository.findByNumberAndManga_Id(number, id).get()
    }

    override fun findByMangaId(id: Long, page: Pageable): List<Chapter> {
        return repository.findByManga_id(id, page).toList()
    }

    override fun findByISBN(isbn: String): Chapter {
        return repository.findByISBN(isbn).get()
    }

    override fun findByRelease(date: Date, page: Pageable): List<Chapter> {
        return repository.findByRelease(date, page).toList()
    }

}