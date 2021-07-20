package pack;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import pack.model.GitRepository;
import pack.step.RepositoriesSteps;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositoriesTests {

	RepositoriesSteps ts = new RepositoriesSteps();
	static List<GitRepository> actualRepositories;

	@BeforeAll
	public void getRepositoryListTest() {
		actualRepositories = ts.getAllReps("selenide");
		System.out.println(actualRepositories);

		Assertions.assertTrue(actualRepositories.size() > 0, "the repository list is empty");
		System.out.println("после getRepositoryListTest");
	}

	@ParameterizedTest
	@MethodSource("getAllRepsNamesAsList")
	public void getRepositoryTest(String repoName) {
		System.out.println("до getRepositoryTest");

		GitRepository currentRepository = ts.getRepository("selenide", repoName);

		String fullName = currentRepository.getFullName();

		Assertions.assertTrue(currentRepository.getFullName() != null, "repository is not found");
		Assertions.assertEquals(fullName, "selenide/selenide-ru", "fullName does not match the intended");
		System.out.println("после getRepositoryTest");
	}

	private static List<String> getAllRepsNamesAsList() {
		List<String> allNames = new ArrayList<>();

		actualRepositories.forEach(gr -> allNames.add(gr.getName()));

		return allNames;
	}
}