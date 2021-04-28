package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.HostingWebsiteDTO
import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import org.springframework.data.domain.Pageable
import java.util.Optional

interface HostingWebsiteService : Service<HostingWebsiteDTO, HostingWebsite> {

    fun findByName(name: String): Optional<HostingWebsite>
    fun findByMangaId(id : Long) : HostingWebsite
    fun findByMangaName(name: String, page: Pageable) : List<HostingWebsite>
    fun findByLanguage(language: String, page: Pageable) : List<HostingWebsite>

}