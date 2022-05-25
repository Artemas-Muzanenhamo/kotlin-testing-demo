package com.example.person.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import com.example.person.domain.Person
import com.example.person.entity.PersonEntity
import com.example.person.repository.PersonRepository

@DisplayName("Mockito Annotation Based Unit Test")
@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {
    @InjectMocks
    private lateinit var personService: PersonService

    @Mock
    private lateinit var personRepository: PersonRepository

    @Test
    fun `Should call the PersonRepository given a Person`() {
        // given
        val person = Person(1L, "kobe", "bryant")

        // when
        personService.create(person)

        // then
        verify(personRepository).save(any(PersonEntity::class.java))
    }

    @Test
    fun `Should Retrieve A Person From The PersonRepository By The Given Name`() {
        // given
        given(personRepository.findFirstByName("jason")).willReturn(PersonEntity(4324L, "jason", "kidd"))

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
        
        verify(personRepository).findFirstByName("jason")
    }
}