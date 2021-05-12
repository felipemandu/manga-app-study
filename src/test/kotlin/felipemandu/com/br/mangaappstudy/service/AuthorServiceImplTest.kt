package felipemandu.com.br.mangaappstudy.service

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.entity.Country
import felipemandu.com.br.mangaappstudy.entity.Genre
import felipemandu.com.br.mangaappstudy.entity.GenreEnum
import felipemandu.com.br.mangaappstudy.entity.HostingWebsite
import felipemandu.com.br.mangaappstudy.entity.Language
import felipemandu.com.br.mangaappstudy.entity.LanguageEnum
import felipemandu.com.br.mangaappstudy.entity.Manga
import felipemandu.com.br.mangaappstudy.mapper.AuthorMapper
import felipemandu.com.br.mangaappstudy.repository.AuthorRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import java.util.*
import javax.validation.ValidationException

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AuthorServiceImplTest {

    @MockK
    lateinit var authorRepository: AuthorRepository

    val authorMapper: AuthorMapper = AuthorMapper()

    @InjectMockKs
    lateinit var authorService: AuthorServiceImpl

    @BeforeAll
    internal fun prepareMockRepository() {
        val (author, page) = prepareMocksObjects()
        val authorList = mutableListOf(author)

        every { authorRepository.findByMangas_TitleLike("titulo") }
            .returns(authorList)

        every { authorRepository.findByMangas_Id(1) }
            .returns(authorList)


        every { authorRepository.findByNameLike("teste") }
            .returns(Optional.of(author))

        every { authorRepository.findByCountryOrigin_NameLike("japan", page) }
            .returns(PageImpl(listOf(author)))


        every { authorRepository.findByCountryOrigin_Id(99) }
            .returns(authorList)
    }

    private fun prepareMocksObjects(): Pair<Author, PageRequest> {
        val hosting = HostingWebsite(id = 1, name = "firstHosting")
        val english = Language(id = 41, language = LanguageEnum.ENGLISH)
        val japanese = Language(id = 73, language = LanguageEnum.JAPANESE)
        val japan =
            Country(id = 99, name = "JAPAN", mangas = mutableSetOf(), spokenLanguage = mutableSetOf(japanese))
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
    fun `throw validation exception if doesn't has given name and last name` () {
        val dto = AuthorInputDTO(name = "João")
        assertThrows<ValidationException> { authorService.create(dto) }
    }

    @Test
    fun getByName() {
        val answer = authorService.getByName("teste")

        Assertions.assertEquals(1, answer.id)
        Assertions.assertEquals("teste", answer.name)
    }

    @Test
    fun getByCountryOriginName() {
        val page = PageRequest.of(1, 100)
        val answer = authorService.getByCountryOriginName("japan", page)

        Assertions.assertEquals(1, answer.size)
        Assertions.assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByCountryOriginId() {
        val answer = authorService.getByCountryOriginId(99)

        Assertions.assertEquals(1, answer.size)
        Assertions.assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByMangaName() {
        val answer = authorService.getByMangaName("titulo")

        Assertions.assertEquals(1, answer.size)
        Assertions.assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }

    @Test
    fun getByMangaId() {
        val answer = authorService.getByMangaId(1)

        Assertions.assertEquals(1, answer.size)
        Assertions.assertEquals("teste", answer[0].name)
        assertThrows<IndexOutOfBoundsException> { answer[1] }
    }
}
