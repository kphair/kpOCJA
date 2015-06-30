package com.kevinphair.ocja.helicopter;

public class Helicopter {

	private String maker;
	private String model;
	private double maxAltitudeInFeet;
	private double currentAltitudeInFeet;
	private boolean engineStatus;
	private int numCrew;
	private int numPassengers;
	private double collectiveSetting;
	private double throttleSetting;
	private double pitch;
	private double roll;
	private double tailRotorSpeed;
	private static final double FEET_PER_METER = 3.28D;
	
	public void setMaker(String newMaker) {
		this.maker = newMaker;
	}
	public String getMaker() {
		return this.maker;
	}
	
	public void setModel(String newModel) {
		this.model = newModel;
	}
	public String getModel() {
		return this.model;
	}

	public void setNumCrew(int newCrew) {
		this.numCrew = newCrew;
	}
	public int getNumCrew() {
		return this.numCrew;
	}

	public void setNumPassengers(int newPassengers) {
		this.numPassengers = newPassengers;
	}
	public int getNumPassengers() {
		return this.numPassengers;
	}


	/*
	 * Engine control
	 */
	public boolean isEngineOn() {
		return this.engineStatus;
	}
	public void startEngine() {
		this.engineStatus = true;
	}
	public void stopEngine() {
		this.engineStatus = false;
	}
	
	/*
	 * Set the max altitude
	 */
	public void setMaxAltitudeInFeet(double newAltitude) {
		this.maxAltitudeInFeet = newAltitude;
	}
	public void setMaxAltitudeInMeters(double newAltitude) {
		this.maxAltitudeInFeet = (newAltitude * FEET_PER_METER);
	}
	/**
	 * @deprecated
	 */
	public void setMaxAltitude(double newAltitude) {
		setMaxAltitudeInFeet(newAltitude);
	}

	/*
	 * Return the max altitude in feet
	 */
	public double getMaxAltitudeInFeet() {
		return this.maxAltitudeInFeet;
	}
	public double getMaxAltitudeInMeters() {
		return (this.maxAltitudeInFeet / FEET_PER_METER);
	}
	/**
	 * @deprecated
	 */
	public double getMaxAltitude() {
		return getMaxAltitudeInFeet();
	}

	/*
	 * Set the current altitude in feet
	 */
	public void setAltitudeInFeet(double newAltitude) {
		this.currentAltitudeInFeet = newAltitude;
	}
	public void setAltitudeInMeters(double newAltitude) {
		this.currentAltitudeInFeet = (newAltitude / FEET_PER_METER);
	}
	/**
	 * @deprecated 
	 */
	public void setAltitude(double newAltitude) {
		setAltitudeInFeet(newAltitude);
	}

	/*
	 * Return the current altitude in feet
	 */
	public double getAltitude() {
		return this.currentAltitudeInFeet;
	}

	public void printAltitude() {
		System.out.println("Current altitude is currently " + getAltitude() + " feet " 
				+ (getAltitude() >= 0 ? "above" : "below") + " sea level");
	}
	
}
