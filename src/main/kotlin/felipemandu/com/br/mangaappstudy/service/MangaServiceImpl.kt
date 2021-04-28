package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Manga
import felipemandu.com.br.mangaappstudy.mapper.MangaMapper
import felipemandu.com.br.mangaappstudy.repository.MangaRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.MangaService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Date
import java.util.Optional

@Service
class MangaServiceImpl(
    override val repository: MangaRepository,
    override val mapper: MangaMapper
) : MangaService {
    override fun findByTitle(title: String, page: Pageable): List<Manga> {
        return repository.findByTitleLike(title, page).toList()
    }

    override fun findByRelease(date: Date, page: Pageable): List<Manga> {
        return repository.findByReleaseGreaterThanEqual(date, page).toList()
    }

    override fun findByRating(rating: Int, page: Pageable): List<Manga> {
        return repository.findByRatingGreaterThanEqual(rating, page).toList()
    }

    override fun findByStatus(status: String, page: Pageable): List<Manga> {
        return repository.findByStatus(status.toUpperCase(), page).toList()
    }

    override fun findByAuthorId(id: Long, page: Pageable): List<Manga> {
        return repository.findByAuthors_Id(id, page).toList()
    }

    override fun findByAuthorName(name: String, page: Pageable): List<Manga> {
        return repository.findByAuthors_NameLike(name, page).toList()
    }

    override fun findByGenre(genre: String, page: Pageable): List<Manga> {
        return repository.findByGenres_GenreLike(genre.toUpperCase(), page).toList()
    }

    override fun findByOriginCountry(country: String, page: Pageable): List<Manga> {
        return repository.findByOriginCountry_NameLike(country.toUpperCase(), page).toList()
    }

    override fun findByOriginLanguage(language: String, page: Pageable): List<Manga> {
        return repository.findByOriginLanguageLike(language.toUpperCase(), page).toList()
    }

    override fun findByTranslatedLanguage(language: String, page: Pageable): List<Manga> {
        return repository.findByTranslatedLanguageLike(language.toUpperCase(), page).toList()
    }

    override fun findByHostingWebsiteId(id: Long, page: Pageable): List<Manga> {
        return repository.findByHostingWebsite_id(id, page).toList()
    }

    override fun findByHostingWebsiteName(name: String, page: Pageable): List<Manga> {
        return repository.findByHostingWebsite_NameLike(name, page).toList()
    }

    override fun findByNumberChapterGreaterThan(number: Int, page: Pageable): List<Manga> {
        return repository.findByChapters_NumberGreaterThanEqual(number, page).toList()
    }

    override fun findByNumberChapterLessThan(number: Int, page: Pageable): List<Manga> {
        return repository.findByChapters_NumberLessThanEqual(number, page).toList()
    }

    override fun findByChapterName(name: String): Optional<Manga> {
        return repository.findByChapters_TitleLike(name)
    }

    override fun findByLastChapterDate(date: Date, page: Pageable): List<Manga> {
        return repository.findByLastChapterGreaterThanEqual(date, page).toList()
    }

}