package pack.step;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pack.api.GitApi;

public class TestSteps {
	private static GitApi api = new GitApi("https://api.github.com");

	@Step
	public static void checkRepositoryList(String url) {
		Response response = api.getResponse(url);

		int statusCode = response.getStatusCode();
		ResponseBody body = response.getBody();

		Assertions.assertEquals(statusCode, 200);
		Assertions.assertNotNull(body);
	}
}
