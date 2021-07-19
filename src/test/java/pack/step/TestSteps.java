package pack.step;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;

public class TestSteps {
	@Step
	public static void checkRepositoryList(int statusCode, ResponseBody body) {
		Assertions.assertEquals(statusCode, 200);
		Assertions.assertNotNull(body);
	}
}
