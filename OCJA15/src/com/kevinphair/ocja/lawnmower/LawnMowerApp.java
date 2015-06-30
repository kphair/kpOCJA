/**
 * App to test the LawnMower class
 * 
 * 
 */
package com.kevinphair.ocja.lawnmower;

public class LawnMowerApp {

	public static void main(String[] args) {

		LawnMower myMower = new LawnMower();

		System.out.println("My mower has " + myMower.getNumWheels() + " wheels.");
		System.out.println("It is a " + myMower.getDriveType() + " type of mower");
		System.out.println("Is it powered on? " + myMower.isMowerOn());
		switch (myMower.getMotiveType()) {
			case MANUAL:
				System.out.println("You need to push it yourself.");
				break;
			case ROLLER:
				System.out.println("It uses a powered roller to move.");
				break;
			case RIDE_ON:
				System.out.println("You sit on it and drive it around.");
				break;
			default:
				System.out.println("It uses an undescribed method of propulsion");
		}
		
	}

}
