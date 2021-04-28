package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.ChapterDTO
import felipemandu.com.br.mangaappstudy.entity.Chapter
import org.springframework.stereotype.Component

@Component
class ChapterMapper: Mapper<ChapterDTO, Chapter> {
    override fun toDto(entity: Chapter): ChapterDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: ChapterDTO): Chapter {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: ChapterDTO, entity: Chapter): Chapter {
        TODO("Not yet implemented")
    }
}