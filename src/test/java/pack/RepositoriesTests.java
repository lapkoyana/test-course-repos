package pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import pack.step.RepositoriesSteps;

public class RepositoriesTests {

	RepositoriesSteps ts = new RepositoriesSteps();

	@Test
	public void repositoryListTest() {
		Response response = ts.getAllReps("selenide");
		Assertions.assertNotNull(response.body());
		Allure.addAttachment("Тело", response.body().asString());
	}

}