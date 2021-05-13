package felipemandu.com.br.mangaappstudy.controller

import com.fasterxml.jackson.databind.ObjectMapper
import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.entity.Author
import felipemandu.com.br.mangaappstudy.mapper.AuthorMapper
import felipemandu.com.br.mangaappstudy.repository.AuthorRepository
import felipemandu.com.br.mangaappstudy.service.AuthorServiceImpl
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import javax.validation.ValidationException

@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AuthorControllerTest {

    @MockK
    lateinit var authorRepository: AuthorRepository

    val authorMapper: AuthorMapper = AuthorMapper()

    @InjectMockKs
    lateinit var authorService: AuthorServiceImpl

    lateinit var authorController: AuthorController


    @BeforeAll
    internal fun mockRepository() {
        authorController = AuthorController(authorService)

        val dto = AuthorInputDTO("Machado de Assis")

        every { authorRepository.save(authorMapper.fromInputToEntity(dto)) }
            .returns(Author(1, dto.name, null, mutableSetOf()))
    }

    @Test
    fun `create a valid author`() {

        val response = authorController.createAuthor(AuthorInputDTO("Machado de Assis"))

        assertEquals(201, response.statusCode.value())
        assertEquals(true, response.hasBody())
        assertEquals("authors/id/1", response.headers.location.toString())
        assertEquals(
            ObjectMapper().writeValueAsString(
                AuthorOutputDTO(1, "Machado de Assis", "UNKNOWN", listOf())
            ),
            ObjectMapper().writeValueAsString(response.body?.resource)
        )
    }

    @Test
    fun `throw a Validation Exception when author name is invalid`() {
        assertThrows<ValidationException> { authorController.createAuthor(AuthorInputDTO("João")) }

    }

}