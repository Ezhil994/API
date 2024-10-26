package org.methods;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApi {
    public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("name", "Ezhil");
		employeeDetails.put("job", "QA Tier-2");
		Response response = RestAssured.given().contentType(ContentType.JSON)
		.body(employeeDetails.toJSONString()).when().post("/api/users");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		if (statusCode==201) {
			System.out.println("Status code matched");
		} else {
			System.out.println("status code not matched");
		}
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		String name = response.jsonPath().getString("name");
		System.out.println("Name: "+name);
		String job = response.jsonPath().getString("job");
		System.out.println("Job: "+job);
	}

}
