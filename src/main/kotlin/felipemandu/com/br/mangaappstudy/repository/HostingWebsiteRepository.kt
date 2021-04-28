package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface HostingWebsiteRepository : JpaRepository<HostingWebsite, Long> {
    fun findByNameLike(name: String): Optional<HostingWebsite>
    fun findByMangas_Id(id: Long): HostingWebsite
    fun findByMangas_TitleLike(title: String, page: Pageable): Page<HostingWebsite>
    fun findByAvailableLanguage(language: String, page: Pageable): Page<HostingWebsite>
}