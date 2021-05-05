package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.AuthorMapper
import felipemandu.com.br.mangaappstudy.dto.MangaDTO
import felipemandu.com.br.mangaappstudy.entity.Manga
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class MangaMapper(
    val mAuthor: AuthorMapper,
    val mLanguage: LanguageMapper,
    val mHosting: HostingWebsiteMapper
) : Mapper<MangaDTO, Manga> {

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

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

