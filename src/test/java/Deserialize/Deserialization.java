package Deserialize;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		FileReader fr = new FileReader("C:\\Users\\ezhil\\eclipse-workspace\\ApiProg\\src\\test\\resources\\CakeOrder.json");
		ObjectMapper ob = new ObjectMapper();
		Root cake = ob.readValue(fr, Root.class);
		String name = cake.getName();
		if (name.contains("Ezhil")) {
			System.out.println("Cake prepared successfully");
		} else {
			System.out.println("Cake not prepared");
		}
		Batters batters = cake.getBatters();
		ArrayList<Batter> batter = batters.getBatter();
		Batter batter2 = batter.get(2);
		String id = batter2.getId();
		if (id.equals("103")) {
			String type = batter2.getType();
			boolean redvelvet = type.equals("Redvelvet");
			System.out.println(redvelvet);
		}
		ArrayList<Topping> topping = cake.getTopping();
		Topping topping2 = topping.get(2);
		String topId = topping2.getId();
		if (topId.equals("203")) {
			String type = topping2.getType();
			System.out.println(type);
		}
		
	}
}
