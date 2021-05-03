package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.CountryDTO
import felipemandu.com.br.mangaappstudy.entity.Country
import org.springframework.data.domain.Pageable


interface CountryService : Service<CountryDTO, Country> {

    fun findByName(name: String): Country
    fun findBySpokenLanguage(spokenLanguage: String, page: Pageable): List<Country>
    fun findByMangaId(id: Long): Country
    fun findByMangaName(name: String): Country
    fun findByAuthorId(id: Long): Country
    fun findByAuthorName(name: String): Country


}