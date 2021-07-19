package pack;

import org.junit.jupiter.api.Test;

import pack.step.TestSteps;

public class ApiTests {
	private String urlAllRepos = "/orgs/selenide/repos";
	private String urlOneRepos = "/repos/selenide/selenide-ru";

	@Test
	public void repositoryListTest() {
		TestSteps.checkRepositoryList(urlAllRepos);
	}

	@Test
	public void oneRepositoryTest() {
		TestSteps.checkRepositoryList(urlOneRepos);
	}
}