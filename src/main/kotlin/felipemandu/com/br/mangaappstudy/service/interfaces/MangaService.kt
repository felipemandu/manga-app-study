package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.MangaDTO
import felipemandu.com.br.mangaappstudy.entity.Manga
import org.springframework.data.domain.Pageable
import java.util.Date
import java.util.Optional

interface MangaService : Service<MangaDTO, Manga> {

    fun findByTitle(title: String, page: Pageable): List<Manga>
    fun findByRelease(date: Date, page: Pageable): List<Manga>
    fun findByRating(rating: Int, page: Pageable): List<Manga>
    fun findByStatus(status: String, page: Pageable): List<Manga>
    fun findByAuthorId(id: Long, page: Pageable): List<Manga>
    fun findByAuthorName(name: String, page: Pageable): List<Manga>
    fun findByGenre(genre: String, page: Pageable): List<Manga>
    fun findByOriginCountry(country: String, page: Pageable): List<Manga>
    fun findByOriginLanguage(language: String, page: Pageable): List<Manga>
    fun findByTranslatedLanguage(language: String, page: Pageable): List<Manga>
    fun findByHostingWebsiteId(id: Long, page: Pageable): List<Manga>
    fun findByHostingWebsiteName(name:String, page:Pageable): List<Manga>
    fun findByNumberChapterGreaterThan(number: Int, page:Pageable): List<Manga>
    fun findByNumberChapterLessThan(number:Int, page:Pageable): List<Manga>
    fun findByChapterName(name:String) : Optional<Manga>
    fun findByLastChapterDate(date: Date, page:Pageable):List<Manga>
}