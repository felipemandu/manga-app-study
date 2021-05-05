package felipemandu.com.br.mangaappstudy.dto

import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class AuthorMapper() : Mapper<AuthorDTO, Author> {

    override fun toDto(entity: Author): AuthorDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: AuthorDTO): Author {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: AuthorDTO, entity: Author): Author {
        TODO("Not yet implemented")
    }


}