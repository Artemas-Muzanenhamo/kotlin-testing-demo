package com.example.person.web

import org.apache.http.HttpHeaders.CONTENT_TYPE
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import com.example.person.domain.Person
import com.example.person.service.PersonService

@WebMvcTest(PersonEndpoint::class)
@DisplayName("Unit Testing the Person API")
class PersonEndpointShould {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var personService: PersonService

    @Test
    fun `Add a Person`() {
        mockMvc.perform(post("/api/people/create")
            .contentType(APPLICATION_JSON)
            .content("""
                {
                    "id": null,
                    "name": "lebron",
                    "surname": "james"
                }
            """.trimIndent()))
            .andExpect(status().isCreated)
    }

    @Test
    fun `Retrieve A Person By Name`() {
        // given
        val person = Person(544234325, "thomas", "jefferson")
        given(personService.retrievePersonByName("thomas")).willReturn(person)

        // when
        mockMvc.perform(get("/api/people/${person.name}"))
            .andExpect(
                content()
                    .json("""
                        {
                            "id": ${person.id},
                            "name": ${person.name},
                            "surname": ${person.surname}
                        }
                    """.trimIndent()))
            // then
            .andExpect(status().is2xxSuccessful)
            .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON_VALUE))
    }
}