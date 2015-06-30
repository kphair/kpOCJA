/*
 * %W% Kevin Phair
 * This app is designed to test the Wristwatch class by exercising the
 * various setters and getters
 */
package com.kevinphair.ocja.wristwatch;

import com.kevinphair.ocja.wristwatch.Wristwatch.*;

/*
 * WristwatchApp class will instantiate and test the Wristwatch class
 * 
 * @version		v1.0
 * @author 		Kevin Phair
 */
public class WristwatchApp {

	public static void main(String[] args) {

		/* Create a new Wristwatch object */
		Wristwatch myWatch = new Wristwatch();
		
		myWatch.setMaker("Casio");
		myWatch.setModel("G-Shock");
		myWatch.setHours(15);
		myWatch.setMinutes(45);
		myWatch.setSeconds(0);
		myWatch.setAnalogue(true);
		myWatch.setDigital(true);
		myWatch.setBatteryType(BatteryTypes.COIN);
		myWatch.setBatteryLevel(100);
		myWatch.setFaceType(FaceTypes.STANDARD);
		
		System.out.println("My watch is a " + myWatch.getMaker() + " " + myWatch.getModel());
		
		if (myWatch.isAnalogue()) {
			System.out.print("The watch face reads " 
								+ myWatch.getAnalogueTime());
		}
		if (myWatch.isAnalogue() && myWatch.isDigital()) {
			System.out.print(" and the ");
		} else {
			System.out.print("The ");
		}
		if (myWatch.isDigital()) {
			System.out.println("digital readout says " 
								+ myWatch.getDigitalTime());
		}
		
		System.out.println("The " + myWatch.getBatteryType() 
							+ " battery level is at " + myWatch.getBatteryLevel() + " percent");
	}

}
