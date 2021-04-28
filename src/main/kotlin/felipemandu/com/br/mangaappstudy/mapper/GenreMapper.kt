package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.GenreDTO
import felipemandu.com.br.mangaappstudy.entity.Genre
import org.springframework.stereotype.Component

@Component
class GenreMapper: Mapper<GenreDTO, Genre> {

    override fun toDto(entity: Genre): GenreDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: GenreDTO): Genre {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: GenreDTO, entity: Genre): Genre {
        TODO("Not yet implemented")
    }

}
