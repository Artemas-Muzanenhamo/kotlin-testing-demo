package testing.example.kotlintestingdemo.web

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import testing.example.kotlintestingdemo.domain.Person

@RestController
class PersonEndpoint {
    @PostMapping("/people/create", consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(CREATED)
    fun createAPerson(@RequestBody person: Person) {
        
    }
}