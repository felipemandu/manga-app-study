package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.mapper.CountryMapper
import felipemandu.com.br.mangaappstudy.repository.CountryRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.CountryService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    override val repository: CountryRepository,
    override val to: CountryMapper
) : CountryService {

    override fun findByName(name: String): Country {
        return repository.findByNameLike(name).get()
    }

    override fun findBySpokenLanguage(spokenLanguage: String, page: Pageable): List<Country> {
        return repository.findBySpokenLanguageLike(spokenLanguage.toUpperCase(), page).toList()
    }

    override fun findByMangaId(id: Long): Country {
        return repository.findByMangas_Id(id).get()
    }

    override fun findByMangaName(name: String): Country {
        return repository.findByMangas_Title(name).get()
    }

    override fun findByAuthorId(id: Long): Country {
        return repository.findByAuthors_Id(id).get()
    }

    override fun findByAuthorName(name: String): Country {
        return repository.findByAuthors_NameLike(name).get()
    }

}