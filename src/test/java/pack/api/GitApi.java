package pack.api;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitApi {
	private String baseUrl;
	
	RequestSpecification requestSpecification = given()
			   .baseUri("https://api.github.com");
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Response getResponse(String url) {
		return given().spec(requestSpecification).when().get(url);
	}
}
