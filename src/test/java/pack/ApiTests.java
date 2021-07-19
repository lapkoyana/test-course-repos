package pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pack.api.GitApi;

public class ApiTests {
	private String urlAllRepos = "/orgs/selenide/repos";
	private String urlOneRepos = "/repos/selenide/selenide-ru";
	private GitApi api = new GitApi("https://api.github.com");

	@Test
	public void repositoryListTest() {
		Assertions.assertEquals(api.getStatusCode(urlAllRepos), 200);
		Assertions.assertNotNull(api.getBody(urlAllRepos));
	}

	@Test
	public void oneRepositoryTest() {
		Assertions.assertEquals(api.getStatusCode(urlOneRepos), 200);
		Assertions.assertNotNull(api.getBody(urlOneRepos));
	}
}