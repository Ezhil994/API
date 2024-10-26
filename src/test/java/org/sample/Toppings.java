package org.sample;

import java.util.ArrayList;

public class Toppings {
	private ArrayList<Topping> toppingList;

	public ArrayList<Topping> getToppingList() {
		return toppingList;
	}
	public Toppings(ArrayList<Topping> toppingList) {
		this.toppingList=toppingList;
	}
}

