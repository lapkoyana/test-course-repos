package pack;

import org.junit.jupiter.api.Test;

import pack.step.RepositoriesSteps;

public class RepositoriesTests {

	RepositoriesSteps ts = new RepositoriesSteps();

	@Test
	public void repositoryListTest() {
		ts.getAllReps("selenide");
	}

}