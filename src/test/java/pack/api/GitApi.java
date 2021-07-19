package pack.api;

import static io.restassured.RestAssured.when;
import io.restassured.response.ResponseBody;

public class GitApi {

	private String baseUrl;

	public GitApi(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int getStatusCode(String url) {
		int statusCode = when().get(baseUrl + url).getStatusCode();
		System.out.println("Status code = " + statusCode);
		return statusCode;
	}

	public ResponseBody getBody(String url) {
		ResponseBody body = when().get(baseUrl + url).getBody();
		System.out.println("Response Body is: \n" + body.asString());// the body is too big
		return body;
	}

}
