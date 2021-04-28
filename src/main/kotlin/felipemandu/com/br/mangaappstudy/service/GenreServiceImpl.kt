package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Genre
import felipemandu.com.br.mangaappstudy.mapper.GenreMapper
import felipemandu.com.br.mangaappstudy.repository.GenreRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.GenreService
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(
    override val repository: GenreRepository,
    override val mapper: GenreMapper
): GenreService {

    override fun findByMangaId(id: Long): List<Genre> {
        return repository.findByMangas_Id(id).toList()
    }

    override fun findByMangaName(name: String): List<Genre> {
        return repository.findByMangas_Title(name).toList()
    }

}