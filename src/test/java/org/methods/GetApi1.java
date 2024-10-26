package org.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetApi1 {
    public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		Response response = RestAssured.given().when().get("/api/users/2");
		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);
		String contentType = response.getContentType();
		System.out.println(contentType);
		int actualCode = response.getStatusCode();
		if (actualCode==200) {
			System.out.println("Status code matched");
		} else {
			System.out.println("Status code not matched");
		}
		String url = response.jsonPath().getString("support.url");
		System.out.println("Url:"+url);
		String text = response.jsonPath().getString("support.text");
		if (text.contains("contributions towards server")) {
			System.out.println("Text: "+text);
		}
		String firstName = response.jsonPath().getString("data.first_name");
		String lastName = response.jsonPath().getString("data.last_name");
		if (firstName.equals("Janet")&&lastName.equals("Weaver")) {
			int id = response.jsonPath().getInt("data.id");
			System.out.println("Id: "+id);
			String email = response.jsonPath().getString("data.email");
			System.out.println("Email: "+email);
			String avatar = response.jsonPath().getString("data.avatar");
			System.out.println("Avatar: "+avatar);
		}
	}

}
