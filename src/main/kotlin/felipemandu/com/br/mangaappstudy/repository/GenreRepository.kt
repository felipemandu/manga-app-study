package felipemandu.com.br.mangaappstudy.repository

import felipemandu.com.br.mangaappstudy.entity.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long> {

    fun findByMangas_Id(id: Long): List<Genre>
    fun findByMangas_Title(title: String): List<Genre>
}
