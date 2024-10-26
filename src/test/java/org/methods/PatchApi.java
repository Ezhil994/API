package org.methods;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchApi {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		JSONObject empDetails = new JSONObject();
		empDetails.put("name", "Adithya");
		empDetails.put("job", "Software test engineer");
		Response patch = RestAssured.given().contentType(ContentType.JSON)
		.body(empDetails.toJSONString()).when().patch("api/users/2");
		String asPrettyString = patch.asPrettyString();
		System.out.println(asPrettyString);
		int statusCode = patch.getStatusCode();
		if (statusCode==200) {
			System.out.println("Status code matched");
		} else {
			System.out.println("Status code not matched");
		}
		String name = patch.jsonPath().getString("name");
		System.out.println(name);
		String job = patch.jsonPath().getString("job");
		System.out.println(job);
	}

}
