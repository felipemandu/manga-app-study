package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.MangaDTO
import felipemandu.com.br.mangaappstudy.entity.Manga
import org.springframework.stereotype.Component

@Component
class MangaMapper: Mapper<MangaDTO, Manga> {

    override fun toDto(entity: Manga): MangaDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: MangaDTO): Manga {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: MangaDTO, entity: Manga): Manga {
        TODO("Not yet implemented")
    }

}
