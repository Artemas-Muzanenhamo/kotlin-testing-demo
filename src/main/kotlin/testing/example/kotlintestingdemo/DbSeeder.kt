package testing.example.kotlintestingdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.entity.PersonEntity
import testing.example.kotlintestingdemo.repository.PersonRepository

@Component
class DbSeeder(
    private val personRepository: PersonRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        
        // in case there is data already in the db
        personRepository.deleteAll()

        val people = listOf(
            PersonEntity(1L, "artemas", "muza"),
            PersonEntity(2L, "john", "doe"),
            PersonEntity(3L, "tracy", "smith"),
            PersonEntity(4L, "sindy", "jackson"),
            PersonEntity(5L, "tom", "hickins"),
            PersonEntity(6L, "gordon", "jeffrey")
        )
        // load on start up
        personRepository.saveAll(people)
    }
}