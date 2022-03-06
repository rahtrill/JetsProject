package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	// Constructor refers to Jet superclass.

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fly() {
		double fuelRange = (super.getRange()) / (super.getSpeed());

		System.out.println("Flying: " + toString());
		System.out.println();
		System.out.printf("The fuel would last for %.2f hours.", fuelRange);
	}

	public double getSpeedInMach() {
		return super.getSpeed() * 0.001303;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	// Create() was created to format the toString() in a way appropriate for reading
	// in a .txt file.

	public String create() {
		return "FighterJet," + super.getModel() + "," + super.getSpeed() + "," + super.getRange() + ","
				+ super.getPrice();
	}

	public void fight() {
		System.out.println("BOOM! Sent this jet to fight: " + toString());
	}

}
