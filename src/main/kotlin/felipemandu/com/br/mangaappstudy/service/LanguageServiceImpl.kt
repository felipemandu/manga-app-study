package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Language
import felipemandu.com.br.mangaappstudy.mapper.LanguageMapper
import felipemandu.com.br.mangaappstudy.repository.LanguageRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.LanguageService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class LanguageServiceImpl(
    override val repository: LanguageRepository,
    override val mapper: LanguageMapper
) :LanguageService{
    override fun findByLanguageName(name: String): Optional<Language> {
        return repository.findByLanguageLike(name)
    }

    override fun findByCountryId(id: Long, page: Pageable): List<Language> {
        return repository.findByCountries_Id(id, page).toList()
    }

    override fun findByCountryName(name: String, page: Pageable): List<Language> {
        return repository.findByCountries_NameLike(name, page).toList()
    }

    override fun findByHostingWebsiteId(id: Long, page: Pageable): List<Language> {
        return repository.findByHostingWebsites_Id(id, page).toList()
    }

    override fun findByHostingWebsiteName(name: String, page: Pageable): List<Language> {
        return repository.findByHostingWebsites_NameLike(name, page).toList()
    }
}