package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.CountryDTO
import felipemandu.com.br.mangaappstudy.entity.Country
import org.springframework.data.domain.Pageable
import java.util.Optional


interface CountryService : Service<CountryDTO, Country> {

    fun findByName(name: String): Optional<Country>
    fun findBySpokenLanguage(spokenLanguage: String, page: Pageable): List<Country>
    fun findByMangaId(id: Long): Optional<Country>
    fun findByMangaName(name: String): Optional<Country>
    fun findByAuthorId(id: Long): Optional<Country>
    fun findByAuthorName(name: String): Optional<Country>


}