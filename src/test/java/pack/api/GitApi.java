package pack.api;

import static io.restassured.RestAssured.*;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pack.info.UrlInfo;

public class GitApi {

	private final RequestSpecification requestSpecification = new RequestSpecBuilder()
			.setBaseUri(UrlInfo.getInstance().getProperties().getProperty("URL")).build();

	@Step("Получение ответа от {url}")
	public Response getResponse(String url) {
		return given().spec(requestSpecification).when().get(url);
	}
}
