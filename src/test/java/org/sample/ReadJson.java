package org.sample;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fr = new FileReader(
				"C:\\Users\\ezhil\\eclipse-workspace\\ApiProg\\src\\test\\resources\\EmployeeDetails.json");
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(fr);
		JSONObject jo =(JSONObject)parse;
		Object empId = jo.get("employeeId");
		System.out.println(empId);
		Object address = jo.get("address");
		JSONObject jo1 = (JSONObject)address;
		Object pincode = jo1.get("pincode");
		System.out.println(pincode);
		Object street = jo1.get("street");
		System.out.println(street);
		Object nameObj = jo.get("name");
		System.out.println(nameObj);
		String name = (String)nameObj;
		if (name.equals("Ajay")) {
			System.out.println("Ajay is a permanent employee");
		}
		Object exp = jo.get("Experience");
		JSONArray jr = (JSONArray)exp;
		Object expCmp = jr.get(2);
		System.out.println(expCmp);
	}

}
