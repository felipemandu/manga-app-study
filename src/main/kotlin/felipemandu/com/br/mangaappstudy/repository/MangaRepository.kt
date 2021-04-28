package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Manga
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.Optional

@Repository
interface MangaRepository : JpaRepository<Manga, Long> {
    fun findByTitleLike(title: String, page: Pageable): Page<Manga>
    fun findByReleaseGreaterThanEqual(date: Date, page: Pageable): Page<Manga>
    fun findByRatingGreaterThanEqual(rating: Int, page: Pageable): Page<Manga>
    fun findByStatus(status: String, page: Pageable): Page<Manga>
    fun findByAuthors_Id(id: Long, page: Pageable): Page<Manga>
    fun findByAuthors_NameLike(name: String, page: Pageable): Page<Manga>
    fun findByGenres_GenreLike(genre: String, page: Pageable): Page<Manga>
    fun findByOriginCountry_NameLike(name: String, page: Pageable): Page<Manga>
    fun findByOriginLanguageLike(language: String, page: Pageable): Page<Manga>
    fun findByTranslatedLanguageLike(language: String, page: Pageable): Page<Manga>
    fun findByHostingWebsite_id(id: Long, page: Pageable): Page<Manga>
    fun findByHostingWebsite_NameLike(name: String, page: Pageable): Page<Manga>
    fun findByChapters_NumberGreaterThanEqual(number: Int, page: Pageable): Page<Manga>
    fun findByChapters_NumberLessThanEqual(number: Int, page: Pageable): Page<Manga>
    fun findByChapters_TitleLike(title: String): Optional<Manga>
    fun findByLastChapterGreaterThanEqual(date: Date, page: Pageable): Page<Manga>
}