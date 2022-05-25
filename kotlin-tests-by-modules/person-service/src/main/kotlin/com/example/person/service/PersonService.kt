package com.example.person.service

import com.example.person.domain.Person
import com.example.person.entity.PersonEntity
import com.example.person.repository.PersonRepository
import org.springframework.stereotype.Service

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
