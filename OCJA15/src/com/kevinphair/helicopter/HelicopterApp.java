/**
 * 
 */
package com.kevinphair.helicopter;

public class HelicopterApp {

	public static void main(String[] args) {

		Helicopter myHeli = new Helicopter();
		
		myHeli.setMaker("McDonnell Douglas");
		myHeli.setModel("AH-64");
		myHeli.setNumCrew(2);

		System.out.println("My helicopter is a " + myHeli.getMaker() + " " + myHeli.getModel());
		System.out.println("Number of crew on board: " + myHeli.getNumCrew());
		System.out.println("Number of passengers on board: " + myHeli.getNumPassengers());
		
		System.out.println("The Engine is currently " + (myHeli.isEngineOn() ? "ON" : "OFF"));
		
		myHeli.printAltitudeInFeet();
		
		System.out.println("Switching on...");
		myHeli.startEngine();
		System.out.println("The Engine is currently " + (myHeli.isEngineOn() ? "ON" : "OFF"));

	}
}
