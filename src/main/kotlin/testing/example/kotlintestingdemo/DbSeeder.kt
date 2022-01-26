package testing.example.kotlintestingdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import testing.example.kotlintestingdemo.domain.Person
import testing.example.kotlintestingdemo.repository.PersonRepository

@Component
class DbSeeder(
    private val personRepository: PersonRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        
        // in case there is data already in the db
        personRepository.deleteAll()

        val people = listOf(
            Person(1L, "artemas", "muza"),
            Person(2L, "john", "doe"),
            Person(3L, "tracy", "smith"),
            Person(4L, "sindy", "jackson"),
            Person(5L, "tom", "hickins"),
            Person(6L, "gordon", "jeffrey")
        )
        // load on start up
        personRepository.saveAll(people)
    }
}