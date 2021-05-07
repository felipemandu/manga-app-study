package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class AuthorMapper : Mapper<AuthorInputDTO, AuthorOutputDTO, Author> {

    override fun toDtoOutput(entity: Author): AuthorOutputDTO {
        return AuthorOutputDTO(
            entity.id,
            entity.name,
            entity.countryOrigin?.name ?: "UNKNOWN",
            entity.mangas?.map { it.title }?.toList() ?: listOf()
        )
    }

    override fun fromInputToEntity(dto: AuthorInputDTO): Author {
        return Author(0L, dto.name, Country(dto.countryId ?: 225, ""), mutableSetOf())
    }

    override fun updateEntity(dto: AuthorInputDTO, entity: Author): Author {
        return Author(entity.id, dto.name, entity.countryOrigin, entity.mangas)
    }


}