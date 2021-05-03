package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.AuthorDTO
import felipemandu.com.br.mangaappstudy.entity.Author
import org.springframework.data.domain.Pageable

interface AuthorService : Service<AuthorDTO, Author> {

    fun getByName(name: String):Author
    fun getByCountryOriginName(name: String, page: Pageable): List<Author>
    fun getByCountryOriginId(id: Long): List<Author>
    fun getByMangaName(name: String): List<Author>
    fun getByMangaId(id: Long): List<Author>

}