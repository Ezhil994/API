package org.sample;

import java.util.ArrayList;

public class Root {
	private int id;
	private String type;
	private String name;
	private double ppu;
	private Batters batters;
	private ArrayList<Topping> topping;
	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public double getPpu() {
		return ppu;
	}
	public Batters getBatters() {
		return batters;
	}
	public ArrayList<Topping> getTopping() {
		return topping;
	}
	public Root(int id,String type,String name,double ppu,Batters batters,ArrayList<Topping> toppings) {
		this.id=id;
		this.type=type;
		this.name=name;
		this.ppu=ppu;
		this.batters=batters;
		this.topping=toppings; 
	}
	

}
