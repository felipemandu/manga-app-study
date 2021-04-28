package felipemandu.com.br.mangaappstudy.mapper

interface Mapper<D,E> {

    fun toDto(entity: E): D
    fun toEntity(dto: D): E
    fun updateEntity(dto: D, entity: E): E
}