package pack;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class ApiTests {
	@Test
	public void repositoryListTest() {
		given().when().get("https://api.github.com/orgs/selenide/repos").then().assertThat().statusCode(200);
	}
}
