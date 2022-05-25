package com.example.person.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.any
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import com.example.person.domain.Person
import com.example.person.entity.PersonEntity
import com.example.person.repository.PersonRepository

@DisplayName("Mockito Kotlin Based Unit Test")
class AnotherPersonServiceTest {
    private val personRepositoryMock = mock<PersonRepository>() {
        on {findFirstByName("jason")}.thenReturn(PersonEntity(4324L, "jason", "kidd"))
    }
    private val personService = PersonService(personRepositoryMock)

    @Test
    fun `Should call the PersonRepository given a Person`() {
        // given
        val person = Person(1L, "kobe", "bryant")

        // when
        personService.create(person)

        // then
        verify(personRepositoryMock).save(any(PersonEntity::class.java))
    }

    @Test
    fun `Should Retrieve A Person From The PersonRepository By The Given Name`() {
        // when
        val person = personService.retrievePersonByName("jason")

        // then
        assertThat(person)
            .isNotNull
            .extracting {
                assertThat(it.id).isEqualTo(4324L)
                assertThat(it.name).isEqualTo("jason")
                assertThat(it.surname).isEqualTo("kidd")
            }

        verify(personRepositoryMock).findFirstByName("jason")
    }
}