package felipemandu.com.br.mangaappstudy.service.interfaces

import felipemandu.com.br.mangaappstudy.mapper.interfaces.Mapper
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.EntityNotFoundException

interface Service<D, E> {
    val repository: JpaRepository<E, Long>
    val to: Mapper<D, E>

    fun create(dto: D): E {
        return repository.save(to.toEntity(dto))
    }

    fun findById(id: Long): E {
        return repository.findById(id).get()
    }

    fun findAll(page: Pageable): List<E> {
        return repository.findAll(page).toList()
    }

    fun update(id: Long, dto: D): E {
        val genericEntity = repository.findById(id).get() ?: throw EntityNotFoundException("Entity with id $id has not been found")
        return repository.save(to.updateEntity(dto, genericEntity))
    }

    fun deleteById(id: Long): Unit {
        repository.deleteById(id)
    }

}