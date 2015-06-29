package com.kevinphair.ocja.wristwatch;

import com.kevinphair.ocja.wristwatch.Wristwatch.BatteryTypes;
import com.kevinphair.ocja.wristwatch.Wristwatch.FaceTypes;

public class WristwatchApp {

	public static void main(String[] args) {

		Wristwatch myWatch = new Wristwatch();
		
		myWatch.setMaker("Casio");
		myWatch.setModel("G-Shock");
		myWatch.setHours(15);
		myWatch.setMinutes(45);
		myWatch.setSeconds(0);
		myWatch.setAnalogue(false);
		myWatch.setDigital(true);
		myWatch.setBatteryType(BatteryTypes.COIN);
		myWatch.setBatteryLevel(100);
		myWatch.setFaceType(FaceTypes.STANDARD);
		
		System.out.println("My watch is a " + myWatch.getMaker() + " " + myWatch.getModel());
		if (myWatch.isAnalogue()) {
			System.out.println("The analogue face currently reads " + myWatch.getTime());
			
		}
		if (myWatch.isDigital()) {
			System.out.println("The digital readout current says " + myWatch.getTime());
		}
	}
	

}
