package pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pack.api.GitApi;
import pack.step.TestSteps;

public class ApiTests {
	private String urlAllRepos = "/orgs/selenide/repos";
	private String urlOneRepos = "/repos/selenide/selenide-ru";
	private GitApi api = new GitApi();

	@Test
	public void repositoryListTest() {
		
		Response response = api.getResponse(urlAllRepos);
		
		int statusCode = response.getStatusCode();
		ResponseBody body = response.getBody();
		
		TestSteps.checkRepositoryList(statusCode, body);
	}

	@Test
	public void oneRepositoryTest() {
		
		Response response = api.getResponse(urlOneRepos);
		
		int statusCode = response.getStatusCode();
		ResponseBody body = response.getBody();
		
		TestSteps.checkRepositoryList(statusCode, body);
	}
}