package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.CountryDTO
import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class CountryMapper : Mapper<CountryDTO, Country> {

    override fun toDto(entity: Country): CountryDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: CountryDTO): Country {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: CountryDTO, entity: Country): Country {
        TODO("Not yet implemented")
    }

}
