package testing.example.kotlintestingdemo.web

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.service.PersonService

@RestController
@RequestMapping("/api")
class PersonEndpoint(
    val personService: PersonService
) {
    
    @PostMapping("/people/create", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(CREATED)
    fun createAPerson(@RequestBody person: Person) {
        personService.create(person)
    }
    
    @GetMapping("/people/{name}", produces = [APPLICATION_JSON_VALUE])
    fun getPersonByName(@PathVariable name: String): Person {
        return personService.retrievePersonByName(name)
    }
}