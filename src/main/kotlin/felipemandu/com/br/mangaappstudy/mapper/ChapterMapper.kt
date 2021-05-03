package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.ChapterDTO
import felipemandu.com.br.mangaappstudy.entity.Chapter
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class ChapterMapper : Mapper<ChapterDTO, Chapter> {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

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