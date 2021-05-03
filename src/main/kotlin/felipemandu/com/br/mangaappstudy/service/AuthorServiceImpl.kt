package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.dto.AuthorMapper
import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.repository.AuthorRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.AuthorService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    override val repository: AuthorRepository,
    override val to: AuthorMapper
) : AuthorService {

    override fun getByName(name: String): Author{
        return repository.findByNameLike(name).get()
    }

    override fun getByCountryOriginName(name: String, page: Pageable): List<Author> {
        return repository.findByCountryOrigin_NameLike(name, page).toList()
    }

    override fun getByCountryOriginId(id: Long): List<Author> {
        return repository.findByCountryOrigin_Id(id)
    }

    override fun getByMangaName(name: String): List<Author> {
        return repository.findByMangas_TitleLike(name)
    }

    override fun getByMangaId(id: Long): List<Author> {
        return repository.findByMangas_Id(id)
    }
}