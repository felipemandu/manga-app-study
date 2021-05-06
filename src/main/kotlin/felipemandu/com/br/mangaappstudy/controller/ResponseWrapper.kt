package felipemandu.com.br.mangaappstudy.controller

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.net.URL

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResponseWrapper<DTO>(
    val status: Int,
    @JsonProperty("resource address")
    val resourceAddress: URL? = null,
    @JsonSerialize(using = CustomSerializer::class)
    val resource: DTO? = null,
    val error: Error? = null
)

class CustomSerializer : JsonSerializer<Any>() {

    override fun serialize(value: Any?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        fun formatClassName(value: Any?): String {
            return if (value!!::class.simpleName?.contains("list", true) == true) {
                return if((value as List<*>).isEmpty())
                    "List"
                else
                    value[0]!!::class.simpleName?.removeSuffix("OutputDTO").plus("s")
            } else {
                value::class.simpleName?.removeSuffix("OutputDTO") ?: "resource"
            }
        }

        gen?.writeStartObject()
        gen?.writeObjectField(formatClassName(value), value)
        gen?.writeEndObject()


    }
}