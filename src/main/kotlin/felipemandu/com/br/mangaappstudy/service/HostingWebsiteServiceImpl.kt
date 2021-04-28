package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import felipemandu.com.br.mangaappstudy.mapper.HostingWebsiteMapper
import felipemandu.com.br.mangaappstudy.repository.HostingWebsiteRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.HostingWebsiteService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HostingWebsiteServiceImpl(
    override val repository: HostingWebsiteRepository,
    override val mapper: HostingWebsiteMapper
): HostingWebsiteService {

    override fun findByName(name: String): Optional<HostingWebsite> {
        return repository.findByNameLike(name)
    }

    override fun findByMangaId(id: Long): HostingWebsite {
        return repository.findByMangas_Id(id)
    }

    override fun findByMangaName(name: String, page: Pageable): List<HostingWebsite> {
        return repository.findByMangas_TitleLike(name, page).toList()
    }

    override fun findByLanguage(language: String, page: Pageable): List<HostingWebsite> {
        return repository.findByAvailableLanguage(language.toUpperCase(), page).toList()
    }

}