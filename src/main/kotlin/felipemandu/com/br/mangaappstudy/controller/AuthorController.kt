package felipemandu.com.br.mangaappstudy.controller

import felipemandu.com.br.mangaappstudy.dto.AuthorInputDTO
import felipemandu.com.br.mangaappstudy.dto.AuthorOutputDTO
import felipemandu.com.br.mangaappstudy.service.interfaces.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/authors")
class AuthorController(@Autowired val authorService: AuthorService) {


    @PostMapping("/")
    fun createAuthor(@RequestBody @Valid authorInputDTO: AuthorInputDTO): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val author = authorService.create(authorInputDTO)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .header(HttpHeaders.LOCATION, "authors/id/${author.id}")
            .body(ResponseWrapper(resource = author))
    }

    @GetMapping("/")
    fun findAllAuthors(
        @RequestParam(name = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(name = "size", required = false, defaultValue = "20") size: Int,
        @RequestParam(name = "sort", required = false, defaultValue = "id") sort: String,
        @RequestParam(name = "dir", required = false, defaultValue = "ASC") dir: String
    ): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val author = authorService.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(dir), sort))
        val resources = ResponseWrapper(
            resources = author.content,
            page = page,
            size = size,
            numberOfPages = author.totalPages
        )
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(resources)
    }

    @GetMapping("/id/{id}")
    fun getAuthorById(@PathVariable("id") id: Long): ResponseEntity<ResponseWrapper<AuthorOutputDTO>> {
        val author = authorService.findById(id)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseWrapper(resource = author))
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
        val resource = authorService.update(id, authorDto)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseWrapper(resource = resource))
    }


}