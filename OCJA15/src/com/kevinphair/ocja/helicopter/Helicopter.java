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
	
	/**
	 * Set the maker string in a helicopter object
	 */
	public void setMaker(String newMaker) {
		this.maker = newMaker;
	}
	/**
	 * Return the maker string in a helicopter object
	 */
	public String getMaker() {
		return this.maker;
	}
	
	/**
	 * Set the model string in a helicopter object
	 */
	public void setModel(String newModel) {
		this.model = newModel;
	}
	/**
	 * Return the model string in a helicopter object
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Set the number of crew in a helicopter object
	 */
	public void setNumCrew(int newCrew) {
		this.numCrew = newCrew;
	}
	/**
	 * Return the number of crew in a helicopter object
	 */
	public int getNumCrew() {
		return this.numCrew;
	}

	/**
	 * Set the number of passengers in a helicopter object
	 */
	public void setNumPassengers(int newPassengers) {
		this.numPassengers = newPassengers;
	}
	/**
	 * Return the number of passengers in a helicopter object
	 */
	public int getNumPassengers() {
		return this.numPassengers;
	}

	/**
	 * Return the boolean status of the engine in a helicopter object
	 */
	public boolean isEngineOn() {
		return this.engineStatus;
	}
	/**
	 * Start the engine in a helicopter object
	 */
	public void startEngine() {
		this.engineStatus = true;
	}
	/**
	 * Stop the engine in a helicopter object
	 */
	public void stopEngine() {
		this.engineStatus = false;
	}
	
	/**
	 * Set the maximum allowable altitude in feet of a helicopter object
	 */
	public void setMaxAltitudeInFeet(double newAltitude) {
		this.maxAltitudeInFeet = newAltitude;
	}
	/**
	 * Set the maximum allowable altitude in metres of a helicopter object
	 */
	public void setMaxAltitudeInMeters(double newAltitude) {
		this.maxAltitudeInFeet = (newAltitude * FEET_PER_METER);
	}
	/**
	 * @deprecated
	 */
	public void setMaxAltitude(double newAltitude) {
		setMaxAltitudeInFeet(newAltitude);
	}

	/**
	 * Return the maximum allowable altitude in feet of a helicopter object
	 */
	public double getMaxAltitudeInFeet() {
		return this.maxAltitudeInFeet;
	}
	/**
	 * Return the maximum allowable altitude in metres of a helicopter object
	 */
	public double getMaxAltitudeInMeters() {
		return (this.maxAltitudeInFeet / FEET_PER_METER);
	}
	/**
	 * @deprecated
	 */
	public double getMaxAltitude() {
		return getMaxAltitudeInFeet();
	}

	/**
	 * Set the current altitude in feet of a helicopter object
	 */
	public void setAltitudeInFeet(double newAltitude) {
		this.currentAltitudeInFeet = newAltitude;
	}
	/**
	 * Set the current altitude in metres of a helicopter object
	 */
	public void setAltitudeInMeters(double newAltitude) {
		this.currentAltitudeInFeet = (newAltitude / FEET_PER_METER);
	}
	/**
	 * @deprecated 
	 */
	public void setAltitude(double newAltitude) {
		setAltitudeInFeet(newAltitude);
	}

	/**
	 * Return the current altitude in feet of a helicopter object
	 */
	public double getAltitudeInFeet() {
		return this.currentAltitudeInFeet;
	}

	/**
	 * Display the current altitude in feet of a helicopter object
	 */
	public void printAltitudeInFeet() {
		System.out.println("Current altitude is currently " + getAltitudeInFeet() + " feet " 
				+ (getAltitudeInFeet() >= 0 ? "above" : "below") + " sea level");
	}
	
}
