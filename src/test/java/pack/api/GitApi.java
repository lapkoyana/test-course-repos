package pack.api;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitApi {

	private final RequestSpecification requestSpecification = new RequestSpecBuilder()
			.setBaseUri("https://api.github.com").build();

	@Step("Получение ответа от {url}")
	public Response getResponse(String url) {
		return given().spec(requestSpecification).when().get(url);
	}
}
