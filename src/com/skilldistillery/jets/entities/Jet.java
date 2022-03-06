package com.skilldistillery.jets.entities;

public abstract class Jet {

	// The Jet superclass holds all of the object values privately.

	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// Abstract methods for all Jet types to be required to use.

	public abstract void fly();

	public abstract double getSpeedInMach();

	public abstract String create();

	// Cannot reference the data from outside this program without the following
	// methods:

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [Model= " + model + ", Speed= " + speed + ", Range= " + range + ", Price= " + price + " ]";
	}
	
	

}
