package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.mapper.Mapper
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import javax.persistence.EntityNotFoundException

interface Service<D, E> {
    val repository: JpaRepository<E, Long>
    val mapper: Mapper<D, E>

    fun create(dto: D): E {
        return repository.save(mapper.toEntity(dto))
    }

    fun findById(id: Long): Optional<E> {
        return repository.findById(id)
    }

    fun findAll(page: Pageable): List<E> {
        return repository.findAll(page).toList()
    }

    fun update(id: Long, dto: D): E {
        val optionalGeneric = repository.findById(id)
        if (optionalGeneric.isEmpty) {
            throw EntityNotFoundException("Entity with id $id has not been Found")
        }
        return repository.save(mapper.updateEntity(dto, optionalGeneric.get()))
    }

    fun deleteById(id: Long): Unit {
        repository.deleteById(id)
    }

}