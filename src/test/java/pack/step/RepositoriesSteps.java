package pack.step;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pack.api.GitApi;

public class RepositoriesSteps {

	private GitApi api = new GitApi();

	@Step("��������� ������ ���� ������������ ����������� {org}")
	public Response getAllReps(String org) {
		String url = String.format("/orgs/%s/repos", org);
		Response response = api.getResponse(url);

		Assertions.assertEquals(response.statusCode(), 200);
		Allure.addAttachment("������", "https://api.github.com" + url);
		Allure.addAttachment("�����", "�� ����������� � ������");
		Allure.addAttachment("��� �������", String.valueOf(response.statusCode()));

		return response;
	}
}