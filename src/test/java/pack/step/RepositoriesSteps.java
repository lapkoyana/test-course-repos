package pack.step;

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
	public List<GitRepository> getAllReps(String org) {
		String url = String.format("/orgs/%s/repos", org);
		Response response = api.getResponse(url);

		String body = response.body().asPrettyString();

		List<GitRepository> actualRepositories = Arrays.asList(response.getBody().as(GitRepository[].class));

		Assertions.assertEquals(response.statusCode(), 200);

		Allure.addAttachment("url", "https://api.github.com" + url);
		Allure.addAttachment("status code", String.valueOf(response.statusCode()));
		Allure.addAttachment("body", body);

		return actualRepositories;
	}

	@Step("ѕолучение репозитори€ {repo} организации {owner}")
	public GitRepository getRepository(String owner, String repo) {
		String url = String.format("/repos/%s/%s", owner, repo);
		Response response = api.getResponse(url);
		String body = response.body().asPrettyString();

		GitRepository currentRepository = response.getBody().as(GitRepository.class);

		Assertions.assertEquals(response.statusCode(), 200);

		Allure.addAttachment("url", "https://api.github.com" + url);
		Allure.addAttachment("status code", String.valueOf(response.statusCode()));
		Allure.addAttachment("body", body);

		return currentRepository;
	}
}
