package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fly() {
		double fuelRange = (super.getRange()) / (super.getSpeed());
		
		System.out.println("Flying: " + toString());
		System.out.println();
		System.out.printf("The fuel would last for %.2f hours.",fuelRange);	}
	
	public double getSpeedInMach() {
		return 0.0;
	}
	
	@Override
	public String toString() {
		return "[Cargo Plane \t Model: " + super.getModel() + "\t Speed: " + super.getSpeed() + "\t Range: "
				+ super.getRange() + "\t Price: $" + super.getPrice() + "]";	}
	
	public void loadCargo() {
		System.out.println("Loading cargo for this jet: " + toString());
	}
	
	
}
