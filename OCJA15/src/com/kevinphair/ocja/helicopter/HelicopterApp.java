/**
 * 
 */
package com.kevinphair.ocja.helicopter;

public class HelicopterApp {

	public static void main(String[] args) {

		Helicopter myHeli = new Helicopter();
		
		myHeli.setMaker("McDonnell Douglas");
		myHeli.setModel("AH-64");
		myHeli.setNumCrew(2);

		System.out.println("My helicopter is a " + myHeli.getMaker() + " " + myHeli.getModel());
		System.out.println("Current crew: " + myHeli.getNumCrew());
		System.out.println("Current passengers: " + myHeli.getNumPassengers());
		
		System.out.println("The Engine is currently " + (myHeli.isEngineOn() ? "ON" : "OFF"));
		
		System.out.println("Current altitude is currently " + myHeli.getAltitude() + " feet " 
							+ (myHeli.getAltitude() >= 0 ? "above" : "below") + " sea level");

		System.out.println("Switching on...");
		myHeli.startEngine();
		System.out.println("The Engine is currently " + (myHeli.isEngineOn() ? "ON" : "OFF"));
		
		
	}
		
}
