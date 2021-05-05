package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Country
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CountryRepository : JpaRepository<Country, Long> {
    fun findByNameLike(name: String): Optional<Country>
    fun findBySpokenLanguageLike(spokenLanguage: String, page: Pageable): Page<Country>
    fun findByMangas_Id(id: Long): Optional<Country>
    fun findByMangas_Title(title: String): Optional<Country>
    fun findByAuthors_Id(id: Long): Optional<Country>
    fun findByAuthors_NameLike(name: String): Optional<Country>
}