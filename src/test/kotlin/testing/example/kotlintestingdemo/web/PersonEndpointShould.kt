package testing.example.kotlintestingdemo.web

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@DisplayName("Unit Testing the Person API")
class PersonEndpointShould {
    @Autowired
    lateinit var mockMvc: MockMvc
    
    @Test
    fun `Add a Person`() {
        mockMvc.perform(post("/people/create")
            .contentType(APPLICATION_JSON)
            .content("""
                {
                    "id": null,
                    "name": "lebron",
                    "surname": "james"
                }
            """.trimIndent()))
            .andExpect(status().is2xxSuccessful)
    }
}