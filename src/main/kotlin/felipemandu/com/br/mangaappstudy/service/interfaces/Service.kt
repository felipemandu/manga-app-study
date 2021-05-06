package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface Service<DTO_INPUT, DTO_OUTPUT, ENTITY> {
    val repository: JpaRepository<ENTITY, Long>
    val mapper: Mapper<DTO_INPUT, DTO_OUTPUT, ENTITY>

    fun create(dto: DTO_INPUT): DTO_OUTPUT {
        val entity = repository.save(mapper.fromInputToEntity(dto))
        return mapper.toDtoOutput(entity)
    }

    fun findById(id: Long): DTO_OUTPUT {
        val optional = repository.findById(id)
        if (optional.isEmpty) {
            throw felipemandu.com.br.mangaappstudy.exception.EntityNotFoundException("Entity with id $id has not been found")
        }
        return mapper.toDtoOutput(optional.get())
    }

    fun findAll(page: Pageable): List<DTO_OUTPUT> {
        return repository.findAll(page).map { mapper.toDtoOutput(it) }.toList()
    }

    fun update(id: Long, dto: DTO_INPUT): DTO_OUTPUT {
        val optional = repository.findById(id)
        if (optional.isEmpty) {
            throw felipemandu.com.br.mangaappstudy.exception.EntityNotFoundException("Entity with id $id has not been found")
        }
        val entity = repository.save(mapper.updateEntity(dto, optional.get()))
        return mapper.toDtoOutput(entity)
    }

    fun deleteById(id: Long): Unit {
        repository.deleteById(id)
    }

}