package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.entity.Author
import org.springframework.data.domain.Pageable

interface AuthorService : Service<AuthorInputDTO, AuthorOutputDTO, Author> {

    fun getByName(name: String):AuthorOutputDTO
    fun getByCountryOriginName(name: String, page: Pageable): List<AuthorOutputDTO>
    fun getByCountryOriginId(id: Long): List<AuthorOutputDTO>
    fun getByMangaName(name: String): List<AuthorOutputDTO>
    fun getByMangaId(id: Long): List<AuthorOutputDTO>

}