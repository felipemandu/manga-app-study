package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.mapper.CountryMapper
import felipemandu.com.br.mangaappstudy.repository.CountryRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.CountryService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CountryServiceImpl(
    override val repository: CountryRepository,
    override val mapper: CountryMapper
) : CountryService {
    override fun findByName(name: String): Optional<Country> {
        return repository.findByNameLike(name)
    }

    override fun findBySpokenLanguage(spokenLanguage: String, page: Pageable): List<Country> {
        return repository.findBySpokenLanguageLike(spokenLanguage.toUpperCase(), page).toList()
    }

    override fun findByMangaId(id: Long): Optional<Country> {
        return repository.findByMangas_Id(id)
    }

    override fun findByMangaName(name: String): Optional<Country> {
        return repository.findByMangas_Title(name)
    }

    override fun findByAuthorId(id: Long): Optional<Country> {
        return repository.findByAuthors_Id(id)
    }

    override fun findByAuthorName(name: String): Optional<Country> {
        return repository.findByAuthors_NameLike(name)
    }

}