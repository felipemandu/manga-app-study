package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.dto.GenreDTO
import felipemandu.com.br.mangaappstudy.entity.Genre

interface GenreService : Service<GenreDTO, Genre> {

    fun findByMangaId(id:Long): List<Genre>
    fun findByMangaName(name: String): List<Genre>

}