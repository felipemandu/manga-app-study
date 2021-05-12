package felipemandu.com.br.mangaappstudy.controller

import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class AuthorControllerIntegrationTest {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `request to create an author correctly`() {

        val request = MockMvcRequestBuilders.post("http://locahost:8080/authors/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JSONObject().put("name", "Machado de Assis").toString())

        mvc.perform(request)
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.resource").exists())
            .andExpect(jsonPath("$.resource.id").value("1"))
            .andExpect(jsonPath("$.resource.name").value("Machado de Assis"))

    }

    @Test
    fun `status code 4xx when resquest to create an author with an empty body`() {
        val request = MockMvcRequestBuilders.post("http://locahost:8080/authors/")
            .contentType(MediaType.APPLICATION_JSON)

        mvc.perform(request)
            .andExpect(status().is4xxClientError)
    }

}