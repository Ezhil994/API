package org.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson1 {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fr = new FileReader(
				"C:\\Users\\ezhil\\eclipse-workspace\\ApiProg\\src\\test\\resources\\CakeOrder1.json");
		JSONParser jp = new JSONParser();
		Object cakeOrder = jp.parse(fr);
		JSONObject jo = (JSONObject)cakeOrder;
		Object batters = jo.get("batters");
		JSONObject jo1 = (JSONObject)batters;
		Object batter = jo1.get("batter");
		JSONArray ja =(JSONArray)batter;
		Object batterObj = ja.get(1);
		JSONObject batter1 =(JSONObject)batterObj;
		Object id = batter1.get("id");
		String s = (String)id;
		if (s.equals("1002")) {
			System.out.println(batter1.get("type"));
		}
		Object topObj = jo.get("topping");
		JSONArray ja1 = (JSONArray)topObj;
		Object topping = ja1.get(4);
		JSONObject top4 =(JSONObject)topping;
		Object typeObj = top4.get("id");
		System.out.println(typeObj);
		String s1=(String)typeObj;
		if (s1.contains("06")) {
			System.out.println(top4.get("type"));
		}
	}

}
