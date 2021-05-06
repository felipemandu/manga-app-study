package felipemandu.com.br.mangaappstudy.mapper


import felipemandu.com.br.mangaappstudy.dto.MangaInputDTO
import felipemandu.com.br.mangaappstudy.dto.MangaOutputDTO
import felipemandu.com.br.mangaappstudy.entity.Manga
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component
import java.time.format.DateTimeFormatter

@Component
class MangaMapper(
    val mAuthor: AuthorMapper,
    val mLanguage: LanguageMapper,
    val mHosting: HostingWebsiteMapper
) : Mapper<MangaInputDTO, MangaOutputDTO, Manga> {

    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    override fun toDtoOutput(entity: Manga): MangaOutputDTO {
        TODO("Not yet implemented")
    }

    override fun toDtoInput(entity: Manga): MangaInputDTO {
        TODO("Not yet implemented")
    }

    override fun fromOutputToToEntity(dto: MangaOutputDTO): Manga {
        TODO("Not yet implemented")
    }

    override fun fromInputToEntity(dto: MangaInputDTO): Manga {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: MangaInputDTO, entity: Manga): Manga {
        TODO("Not yet implemented")
    }


}

