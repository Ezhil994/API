package org.methods;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutApi {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		JSONObject employeeDetails = new JSONObject();
		employeeDetails.put("name", "Ezhil");
		employeeDetails.put("job", "Software test engineer");
		Response response = RestAssured.given().contentType(ContentType.JSON)
		.body(employeeDetails.toJSONString()).when().put("/api/users/2");
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		int statusCode = response.getStatusCode();
		if (statusCode==200) {
			System.out.println("Status code matched");
		} else {
			System.out.println("Status code not matched");
		}
		String updatedAt = response.jsonPath().getString("updatedAt");
		if (updatedAt.contains("2024-10-09")) {
			String name = response.jsonPath().getString("name");
			System.out.println("Name: "+name);
			String job = response.jsonPath().getString("job");
			System.out.println("Job: "+job);
		}
	}

}
