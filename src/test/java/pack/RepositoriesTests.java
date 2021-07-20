package pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import pack.step.RepositoriesSteps;

public class RepositoriesTests {

	RepositoriesSteps ts = new RepositoriesSteps();

	@Test
	public void getRepositoryListTest() {
		Response response = ts.getAllReps("selenide");

		Assertions.assertNotNull(response.body());
	}

	@Test
	public void getRepositoryTest() {
		Response response = ts.getRepository("selenide", "selenide-ru");

		Assertions.assertNotNull(response.body());
	}
}