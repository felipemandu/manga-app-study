package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.LanguageInputDTO
import felipemandu.com.br.mangaappstudy.dto.LanguageOutputDTO
import felipemandu.com.br.mangaappstudy.entity.Language
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class LanguageMapper: Mapper<LanguageInputDTO, LanguageOutputDTO, Language> {
    override fun toDtoOutput(entity: Language): LanguageOutputDTO {
        TODO("Not yet implemented")
    }


    override fun fromInputToEntity(dto: LanguageInputDTO): Language {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: LanguageInputDTO, entity: Language): Language {
        TODO("Not yet implemented")
    }

}
