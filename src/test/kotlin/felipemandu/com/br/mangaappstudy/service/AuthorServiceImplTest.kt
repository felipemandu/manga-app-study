package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.entity.Genre
import felipemandu.com.br.mangaappstudy.entity.GenreEnum
import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import felipemandu.com.br.mangaappstudy.entity.Language
import felipemandu.com.br.mangaappstudy.entity.LanguageEnum
import felipemandu.com.br.mangaappstudy.entity.Manga
import felipemandu.com.br.mangaappstudy.repository.AuthorRepository
import felipemandu.com.br.mangaappstudy.service.interfaces.AuthorService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import java.util.Optional

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AuthorServiceImplTest(@Autowired val authorService: AuthorService) {


    @MockBean
    lateinit var authorRepository: AuthorRepository


    @BeforeEach
    internal fun prepareMockRepository() {
        val (author, page) = prepareMocksObjects()
        val authorList = mutableListOf(author)
        Mockito.`when`(authorRepository.findByMangas_TitleLike("titulo")).thenReturn(authorList)

        Mockito.`when`(authorRepository.findByMangas_Id(1)).thenReturn(authorList)

        Mockito.`when`(authorRepository.findByNameLike("teste")).thenReturn(Optional.of(author))

        Mockito.`when`(authorRepository.findByCountryOrigin_NameLike("japan", page))
            .thenReturn(PageImpl(listOf(author)))


        Mockito.`when`(authorRepository.findByCountryOrigin_Id(99)).thenReturn(authorList)
    }

    private fun prepareMocksObjects(): Pair<Author, PageRequest> {
        val hosting = HostingWebsite(id = 1, name = "firstHosting")
        val english = Language(id = 41, language = LanguageEnum.ENGLISH)
        val japanese = Language(id = 73, language = LanguageEnum.JAPANESE)
        val japan = Country(id = 99, name = "JAPAN", mangas = mutableSetOf(), spokenLanguage = mutableSetOf(japanese))
        val genre = Genre(id = 1, genre = GenreEnum.ACTION)
        val manga = Manga(
            id = 1,
            title = "titulo",
            translatedLanguage = english,
            genres = mutableSetOf(genre),
            hostingWebsite = hosting
        )
        val author = Author(id = 1, name = "teste", countryOrigin = japan, mangas = mutableSetOf(manga))

        hosting.mangas?.add(manga)
        genre.mangas?.add(manga)
        manga.authors?.add(author)

        val page = PageRequest.of(1, 100)
        return Pair(author, page)
    }


    @Test
    fun getByName() {
        val answer = authorService.getByName("teste")

        assertEquals(1, answer.id)
        assertEquals("teste", answer.name)
    }

    @Test
    fun getByCountryOriginName() {
        val page = PageRequest.of(1, 100)
        val answer = authorService.getByCountryOriginName("japan", page)

        assertEquals(1, answer.size)
        assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByCountryOriginId() {
        val answer = authorService.getByCountryOriginId(99)

        assertEquals(1, answer.size)
        assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByMangaName() {
        val answer = authorService.getByMangaName("titulo")

        assertEquals(1, answer.size)
        assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByMangaId() {
        val answer = authorService.getByMangaId(1)

        assertEquals(1, answer.size)
        assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

}