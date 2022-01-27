package testing.example.kotlintestingdemo.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.any
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.entity.PersonEntity
import testing.example.kotlintestingdemo.repository.PersonRepository

@DisplayName("Mockito Kotlin Based Unit Test")
class AnotherPersonServiceTest {
    private val personRepository = mock<PersonRepository>()
    private val personService = PersonService(personRepository)

    @Test
    fun `Should call the PersonRepository given a Person`() {
        // given
        val person = Person(1L, "kobe", "bryant")

        // when
        personService.create(person)

        // then
        verify(personRepository).save(any(PersonEntity::class.java))
    }
}