package felipemandu.com.br.mangaappstudy.controller

import felipemandu.com.br.mangaappstudy.exception.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime
import javax.validation.ValidationException

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(e: ValidationException): ResponseEntity<Error> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(getError(e))

    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(e: EntityNotFoundException): ResponseEntity<Error> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(getError(e))
    }

    private fun getError(e: Exception): Error {

        return Error(e::class.simpleName!!, e.localizedMessage!!, LocalDateTime.now())
    }


}