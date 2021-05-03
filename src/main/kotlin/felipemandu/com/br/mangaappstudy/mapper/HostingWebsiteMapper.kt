package felipemandu.com.br.mangaappstudy.mapper

import felipemandu.com.br.mangaappstudy.dto.HostingWebsiteDTO
import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.stereotype.Component

@Component
class HostingWebsiteMapper: Mapper<HostingWebsiteDTO, HostingWebsite> {

    override fun toDto(entity: HostingWebsite): HostingWebsiteDTO {
        TODO("Not yet implemented")
    }

    override fun toEntity(dto: HostingWebsiteDTO): HostingWebsite {
        TODO("Not yet implemented")
    }

    override fun updateEntity(dto: HostingWebsiteDTO, entity: HostingWebsite): HostingWebsite {
        TODO("Not yet implemented")
    }


}
