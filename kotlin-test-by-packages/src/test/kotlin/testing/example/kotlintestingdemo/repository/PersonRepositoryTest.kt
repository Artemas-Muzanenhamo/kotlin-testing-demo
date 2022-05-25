package testing.example.kotlintestingdemo.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import testing.example.kotlintestingdemo.entity.PersonEntity

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private lateinit var personRepository: PersonRepository 
    
    @Test
    fun `Should Retrieve A Person By Name`() {
        // given
        personRepository.save(PersonEntity(null, "artemas", "prime"))

        // when
        val person = personRepository.findFirstByName("artemas")
        
        // then
        assertThat(person)
            .isNotNull
            .extracting { 
                assertThat(it.id).isEqualTo(1L)
                assertThat(it.name).isEqualTo("artemas")
                assertThat(it.surname).isEqualTo("prime")
            }
    }
}