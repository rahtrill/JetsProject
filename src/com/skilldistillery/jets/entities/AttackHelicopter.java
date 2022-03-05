package com.skilldistillery.jets.entities;

public class AttackHelicopter extends Jet implements CargoCarrier, CombatReady {
	public AttackHelicopter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fly() {
		double fuelRange = (super.getRange()) / (super.getSpeed());
		
		System.out.println("Flying: " + toString());
		System.out.println();
		System.out.printf("The fuel would last for %.2f hours.",fuelRange);
	}

	public double getSpeedInMach() {
		return 0.0;
	}

	@Override
	public String toString() {
		return "[Attack Helicopter \t Model: " + super.getModel() + "\t Speed: " + super.getSpeed() + "\t Range: "
				+ super.getRange() + "\t Price: $" + super.getPrice() + "]";
	}
	
	public String create() {
		return "AttackHelicopter," + super.getModel() + "," + super.getSpeed() + ","
				+ super.getRange() + "," + super.getPrice();
	}

	public void loadCargo() {
		System.out.println("Loading cargo for this jet: " + toString());
	}

	public void fight() {
		System.out.println("BOOM! Sent this jet to fight: " + toString());
	}

}
