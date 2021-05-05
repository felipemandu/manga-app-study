package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Language
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LanguageRepository : JpaRepository<Language, Long> {
    fun findByLanguageLike(language: String): Optional<Language>
    fun findByCountries_Id(id: Long, page: Pageable): Page<Language>
    fun findByCountries_NameLike(name: String, page: Pageable): Page<Language>
    fun findByHostingWebsites_Id(id: Long, page: Pageable): Page<Language>
    fun findByHostingWebsites_NameLike(name: String, page: Pageable): Page<Language>
}