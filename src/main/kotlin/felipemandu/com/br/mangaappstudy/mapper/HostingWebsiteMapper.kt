package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.HostingWebsiteInputDTO
import felipemandu.com.br.mangaappstudy.dto.HostingWebsiteOutputDTO
import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class HostingWebsiteMapper: Mapper<HostingWebsiteInputDTO, HostingWebsiteOutputDTO, HostingWebsite> {
    override fun toDtoOutput(entity: HostingWebsite): HostingWebsiteOutputDTO {
        TODO("Not yet implemented")
    }

    override fun fromInputToEntity(dto: HostingWebsiteInputDTO): HostingWebsite {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: HostingWebsiteInputDTO, entity: HostingWebsite): HostingWebsite {
        TODO("Not yet implemented")
    }


}
