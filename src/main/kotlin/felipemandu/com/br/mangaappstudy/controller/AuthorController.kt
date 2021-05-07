package felipemandu.com.br.mangaappstudy.controller

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.exception.AuthorNotFound
import felipemandu.com.br.mangaappstudy.exception.EntityNotFoundException
import felipemandu.com.br.mangaappstudy.service.interfaces.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.net.URL
import javax.validation.Valid


@Controller
@RequestMapping("/authors")
class AuthorController(@Autowired val authorService: AuthorService) {

    val host = "http://localhost:8080/authors"

    @PostMapping("/")
    fun createAuthor(@RequestBody @Valid authorInputDTO: AuthorInputDTO): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val response = try {
            val author = authorService.create(authorInputDTO)
            val resourceAddress = URL("$host/id/${author.id}")

            ResponseWrapper(status = HttpStatus.CREATED.value(), resource = author, resourceAddress = resourceAddress)
        } catch (e: AuthorNotFound) {
            val error: Error = Error(AuthorNotFound::class.simpleName!!, e.localizedMessage!!)
            ResponseWrapper(status = HttpStatus.NOT_FOUND.value(), error = error)
        }

        return ResponseEntity(response, HttpStatus.resolve(response.status)!!)
    }

    @GetMapping("/")
    fun findAllAuthors(
        @RequestParam(name = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(name = "size", required = false, defaultValue = "20") size: Int,
        @RequestParam(name = "sort", required = false, defaultValue = "id") sort: String,
        @RequestParam(name = "dir", required = false, defaultValue = "ASC") dir: String
    ): ResponseEntity<ResponseWrapper<List<AuthorOutputDTO>>> {
        val response = try {
            val author = authorService.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(dir), sort))
            ResponseWrapper(status = HttpStatus.OK.value(), resource = author)
        } catch (e: AuthorNotFound) {
            val error: Error = Error(AuthorNotFound::class.simpleName!!, e.localizedMessage!!)
            ResponseWrapper(status = HttpStatus.NOT_FOUND.value(), error = error)
        }
        return ResponseEntity(response, HttpStatus.resolve(response.status)!!)
    }

    @GetMapping("/id/{id}")
    fun getAuthorById(@PathVariable("id") id: Long): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val response = try {
            val author = authorService.findById(id)

            ResponseWrapper(status = HttpStatus.OK.value(), resource = author)
        } catch (e: EntityNotFoundException) {

            val error: Error = Error(AuthorNotFound::class.simpleName!!, e.localizedMessage!!)
            ResponseWrapper(status = HttpStatus.NOT_FOUND.value(), error = error)
        }

        return ResponseEntity(response, HttpStatus.resolve(response.status)!!)
    }

    @DeleteMapping("/id/{id}")
    fun deleteAuthorById(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        authorService.deleteById(id)
        return ResponseEntity.ok().build()
    }

    @PutMapping("/id/{id}")
    fun updateAuthor(
        @PathVariable id: Long,
        @RequestBody authorDto: AuthorInputDTO
    ): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val response: ResponseWrapper<AuthorOutputDTO> = try {
            ResponseWrapper(status = 200, resource = authorService.update(id, authorDto))
        } catch (e: Exception) {
            if (e is EntityNotFoundException)
                ResponseWrapper(
                    status = HttpStatus.NOT_FOUND.value(),
                    error = Error(AuthorNotFound::class.simpleName!!, e.localizedMessage!!)
                )
            else
                ResponseWrapper(
                    status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    error = Error(e::class.simpleName!!, e.localizedMessage!!)
                )
        }

        return ResponseEntity(response, HttpStatus.resolve(response.status)!!)
    }


}