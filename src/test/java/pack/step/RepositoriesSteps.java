package pack.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pack.api.GitApi;
import pack.model.GitRepository;

public class RepositoriesSteps {

	private GitApi api = new GitApi();

	@Step("ѕолучение списка всех репозиториев организации {org}")
	public Response getAllReps(String org) {
		String url = String.format("/orgs/%s/repos", org);
		Response response = api.getResponse(url);

		List<GitRepository> list = Arrays.asList(response.getBody().as(GitRepository[].class));
		List<String> stringList = new ArrayList<>();
		for (GitRepository gr : list) {
			stringList.add(gr.toString());
		}
		String[] strings = stringList.stream().toArray(String[]::new);
		String string = String.join(",", strings);

		Assertions.assertEquals(response.statusCode(), 200);

		Allure.addAttachment("url", "https://api.github.com" + url);
		Allure.addAttachment("status code", String.valueOf(response.statusCode()));
		Allure.addAttachment("body", string);

		return response;
	}

	@Step("ѕолучение репозитори€ {repo} организации {owner}")
	public Response getRepository(String owner, String repo) {
		String url = String.format("/repos/%s/%s", owner, repo);
		Response response = api.getResponse(url);

		GitRepository gr = response.getBody().as(GitRepository.class);
		String fullName = gr.getFullName();
		String grString = gr.toString();

		Assertions.assertEquals(response.statusCode(), 200);
		Assertions.assertEquals(fullName, "selenide/selenide-ru");

		Allure.addAttachment("url", "https://api.github.com" + url);
		Allure.addAttachment("status code", String.valueOf(response.statusCode()));
		Allure.addAttachment("full-name", fullName);
		Allure.addAttachment("body", grString);

		return response;
	}
}
