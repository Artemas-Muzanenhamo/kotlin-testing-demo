import io.restassured.RestAssured.given
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import testing.example.kotlintestingdemo.KotlinTestingDemoApplication

@SpringBootTest(classes = [KotlinTestingDemoApplication::class], webEnvironment = DEFINED_PORT)
@DisplayName("Integration Test")
class PersonCreationTest {
    @Test
    @DisplayName("Create Person Created")
    fun createAndFindPerson() {
        given()
            .body(
                """
                    {
                        "id": null,
                        "name": "test",
                        "surname": "folk"
                    }
                """.trimIndent()
            )
            .contentType(APPLICATION_JSON_VALUE)
            .post("/api/people/create")
            .then()
            .statusCode(HttpStatus.CREATED.value())
    }
}