package felipemandu.com.br.mangaappstudy.mapper.interfaces

interface Mapper<DTO_INPUT, DTO_OUTPUT, ENTITY> {
    fun toDtoOutput(entity: ENTITY): DTO_OUTPUT
    fun toDtoInput(entity: ENTITY): DTO_INPUT
    fun fromOutputToToEntity(dto: DTO_OUTPUT): ENTITY
    fun fromInputToEntity(dto: DTO_INPUT): ENTITY
    fun updateEntity(dto: DTO_INPUT, entity: ENTITY): ENTITY

}