package pack.api;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitApi {

	private String baseUrl;

	private RequestSpecification requestSpecification;

	public GitApi(String baseUrl) {
		this.baseUrl = baseUrl;
		requestSpecification = given().baseUri(baseUrl);
	}

	public Response getResponse(String url) {
		return given().spec(requestSpecification).when().get(url);
	}
}
