package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly() {
		double fuelRange = (super.getRange()) / (super.getSpeed());
		
		System.out.println("Flying: " + toString());
		System.out.println();
		System.out.printf("The fuel would last for %.2f hours.",fuelRange);	}
	
	public double getSpeedInMach() {
		return super.getSpeed() * 0.001303;
	}
	
	@Override
	public String toString() {
		return "[Fighter Jet \t Model: " + super.getModel() + "\t Speed: " + super.getSpeed() + "\t Range: "
				+ super.getRange() + "\t Price: $" + super.getPrice() + "]";	}
	
	public String create() {
		return "FighterJet," + super.getModel() + "," + super.getSpeed() + ","
				+ super.getRange() + "," + super.getPrice();
	}
	
	public void fight() {
		System.out.println("BOOM! Sent this jet to fight: " + toString());
	}
	
	
}
