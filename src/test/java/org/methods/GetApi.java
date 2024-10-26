package org.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi {
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().queryParam("page","2").when().get("/api/users");
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		int actualCode = response.getStatusCode();
		int expectedCode = 200;
		if (actualCode==expectedCode) {
			System.out.println("Status code matched");
		} else {
			System.out.println("Status code not matched");
		}
		int id = response.jsonPath().getInt("data[4].id");
		String email = response.jsonPath().getString("data[4].email");
		if (id==11 && email.equals("george.edwards@reqres.in")) {
			String firstName = response.jsonPath().getString("data[4].first_name");
			System.out.println("First name: "+firstName);
			String lastName = response.jsonPath().getString("data[4].last_name");
			System.out.println("Last name: "+lastName);
			String avatar = response.jsonPath().getString("data[4].avatar");
			System.out.println("Avatar: "+avatar);
		}else {
			System.out.println("Id and email not matched");
		}
	}
}
