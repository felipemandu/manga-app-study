package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.LanguageDTO
import felipemandu.com.br.mangaappstudy.entity.Language
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class LanguageMapper: Mapper<LanguageDTO, Language> {

    override fun toDto(entity: Language): LanguageDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: LanguageDTO): Language {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: LanguageDTO, entity: Language): Language {
        TODO("Not yet implemented")
    }


}
