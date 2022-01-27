package testing.example.kotlintestingdemo.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.entity.PersonEntity
import testing.example.kotlintestingdemo.repository.PersonRepository

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
        val personEntity = PersonEntity(person.id, person.name, person.surname)
        
        // when
        personService.create(person)
        
        // then
        verify(personRepository).save(any(PersonEntity::class.java))
    }
}