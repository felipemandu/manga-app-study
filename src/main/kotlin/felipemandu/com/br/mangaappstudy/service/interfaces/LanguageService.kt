package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.LanguageDTO
import felipemandu.com.br.mangaappstudy.entity.Language
import org.springframework.data.domain.Pageable

interface LanguageService : Service<LanguageDTO, Language> {

    fun findByLanguageName(name:String): Language
    fun findByCountryId(id: Long, page: Pageable): List<Language>
    fun findByCountryName(name: String, page: Pageable): List<Language>
    fun findByHostingWebsiteId(id: Long, page: Pageable):List<Language>
    fun findByHostingWebsiteName(name: String, page: Pageable):List<Language>
}