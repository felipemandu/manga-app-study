package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Author
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
    fun findByNameLike(name: String): Optional<Author>
    fun findByCountryOrigin_NameLike(countryOrigin: String, page: Pageable) : Page<Author>
    fun findByMangas_TitleLike(manga: String): List<Author>
    fun findByCountryOrigin_Id(id: Long): List<Author>
    fun findByMangas_Id(id: Long): List<Author>

}