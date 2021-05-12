package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.exception.AuthorNotFound
import felipemandu.com.br.mangaappstudy.mapper.AuthorMapper
import felipemandu.com.br.mangaappstudy.repository.AuthorRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.AuthorService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.validation.ValidationException

@Service
class AuthorServiceImpl(
    override val repository: AuthorRepository,
    override val mapper: AuthorMapper
) : AuthorService {

    override fun create(dto: AuthorInputDTO): AuthorOutputDTO {
        val numberOfWords = dto.name
            .split(" ")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .count()
        if(numberOfWords <= 1) {
            throw ValidationException("The Author must have a given name and a last name separated by a space")
        }
        return super.create(dto)
    }
    override fun getByName(name: String): AuthorOutputDTO {
        val authorOptional = repository.findByNameLike(name)
        if (authorOptional.isEmpty) {
            throw AuthorNotFound("The author with name $name doesn't has been found")
        }
        return mapper.toDtoOutput(authorOptional.get())
    }

    override fun getByCountryOriginName(name: String, page: Pageable): List<AuthorOutputDTO> {
        return repository.findByCountryOrigin_NameLike(name, page).map { mapper.toDtoOutput(it) }.toList()
    }

    override fun getByCountryOriginId(id: Long): List<AuthorOutputDTO> {
        return repository.findByCountryOrigin_Id(id).map { mapper.toDtoOutput(it) }.toList()
    }

    override fun getByMangaName(name: String): List<AuthorOutputDTO> {
        return repository.findByMangas_TitleLike(name).map { mapper.toDtoOutput(it) }.toList()
    }

    override fun getByMangaId(id: Long): List<AuthorOutputDTO> {
        return repository.findByMangas_Id(id).map { mapper.toDtoOutput(it) }.toList()
    }
}