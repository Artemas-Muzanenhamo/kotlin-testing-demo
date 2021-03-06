package testing.example.kotlintestingdemo.service

import org.springframework.stereotype.Service
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.entity.PersonEntity
import testing.example.kotlintestingdemo.repository.PersonRepository

@Service
class PersonService(
    val personRepository: PersonRepository
) {
    fun create(person: Person) {
        personRepository.save(person.toEntity())
    }

    fun Person.toEntity(): PersonEntity {
        return PersonEntity(
            id = this.id,
            name = this.name,
            surname = this.surname
        )
    }

    fun retrievePersonByName(name: String): Person {
        return personRepository.findFirstByName(name).toDomain() ?: throw Exception("Person does not exist")
    }
    
    fun PersonEntity.toDomain(): Person? {
        return Person(
            id = this.id,
            name = this.name,
            surname = this.surname
        )
    }

}
