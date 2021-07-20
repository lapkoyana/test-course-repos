package pack.step;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pack.api.GitApi;

public class RepositoriesSteps {

	private GitApi api = new GitApi();

	@Step("ѕолучение списка всех репозиториев организации selenide")
	public Response getAllReps(String org) {
		String url = String.format("/orgs/%s/repos", org);
		Response response = api.getResponse(url);

		Assertions.assertEquals(response.statusCode(), 200);

		return response;
	}
}
