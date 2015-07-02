/**
 * Code Challenge for July 2nd 
 */
package com.kevinphair.ocja.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 2.0
 */
public class CodeChallengeIf {

	public static void main(String[] args) {

		int choice = 0;
		double weightInKg = 0;
		String division = "";
		final double POUNDS_PER_KILO = 2.20462;

		Scanner scan = new Scanner(System.in);
		
		mainloop:
			while (true) {
				System.out.println("Please select 1 or 2 from the options below\n");
				System.out.println("1) Enter weight in kilos");
				System.out.println("2) Enter weight in pounds");

				try {
					choice = scan.nextInt();

				} catch (InputMismatchException e) {
					System.out.println("Error in selection. Please only enter 1 or 2.");
					scan.next();			// Empty the offending token from Scanner's buffer
				}
				
				if (choice == 1 || choice == 2) {
					break mainloop;
				}
			}

		weightloop:
			while (true) {
				try {
					if(choice==1){
						System.out.println("Enter weight in kilos: ");
						weightInKg = scan.nextInt();
						break weightloop;
					} else if(choice == 2){
						System.out.println("Enter weight in pounds: ");
						weightInKg = scan.nextInt()/POUNDS_PER_KILO;
						break weightloop;
					}
				} catch (InputMismatchException e) {
					System.out.println("Error entering weight. Please enter a whole number.");
					scan.next();
				}
			}

		if ( weightInKg < 67 || weightInKg > 120 ){
			System.out.println("You are ineligible for the competition");
		} else if (weightInKg < 71) {
			division = "Lightweight";
		} else if (weightInKg < 78) {
			division = "Welterweight";
		} else if (weightInKg < 85) {
			division = "Middleweight";
		} else if (weightInKg < 94) {
			division = "Light Heavyweight";
		} else {
			division = "Heavyweight";
		}

		System.out.println("Your weight in kg is " + weightInKg);
		if (division != "") {
			System.out.println("Your division is " + division);
		} else {
			System.out.println("Sorry, better luck next time.");
		}

		scan.close();
	}

}