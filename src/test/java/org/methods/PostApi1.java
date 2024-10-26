package org.methods;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApi1 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		JSONObject registerCredentials = new JSONObject();
		registerCredentials.put("email", "eve.holt@reqres.in");
		registerCredentials.put("password", "pistol");
		Response response = RestAssured.given().contentType(ContentType.JSON)
		.body(registerCredentials.toJSONString()).when().post("/api/register");
		int statusCode = response.getStatusCode();
		if (statusCode==201) {
			System.out.println("Status code matched");
		} else {
			System.out.println("Status code not matched");
		}
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		String id = response.jsonPath().getString("id");
		System.out.println("Id: "+id);
		String token = response.jsonPath().getString("token");
		System.out.println("Token: "+token);
	}

}
