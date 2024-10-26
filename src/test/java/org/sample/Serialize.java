package org.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialize {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		File cakeOrder = new File("C:\\Users\\ezhil\\eclipse-workspace\\ApiProg\\src\\test\\resources\\CakeOrder.json");
		ObjectMapper ob = new ObjectMapper();
		ArrayList<Batter> batterList = new ArrayList<Batter>();
		batterList.add(new Batter("101", "Regular"));
		batterList.add(new Batter("102", "Blackforest"));
		batterList.add(new Batter("103", "Redvelvet"));
		batterList.add(new Batter("104", "Chocolate"));
		batterList.add(new Batter("105", "Choco Truffle"));
		batterList.add(new Batter("106", "Strawberry"));
		Batters batters = new Batters(batterList);
		
		ArrayList<Topping> toppingList=new ArrayList<Topping>();
		toppingList.add(new Topping("201", "none"));
		toppingList.add(new Topping("202", "Glazed"));
		toppingList.add(new Topping("203", "Maple"));
		toppingList.add(new Topping("204", "Chocolate"));
		toppingList.add(new Topping("205", "Chocolate with Sprinkles"));
		toppingList.add(new Topping("205", "Powdered Sugar"));
		
		Toppings toppings = new Toppings(toppingList);
		Root cake = new Root(11, "Cake", "Ezhil", 1.50, batters, toppingList);
		ob.writeValue(cakeOrder, cake);
	}
	
}
