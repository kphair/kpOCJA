package com.kevinphair.ocja.exercises;

import java.util.Scanner;

public class LeapYearTest {

	public static void main(String[] args) {
		
		int testYear = 0;
		
		System.out.println("Please enter a year for checking");

		Scanner scan = new Scanner(System.in);
		while (! scan.hasNextInt()) {
			scan.next();
		}
		testYear = scan.nextInt();
		
		/* Leap year test.
		 * Leap year is every 4 years
		 * Except every 400th year, unless it's a millennium
		 */
		if (testYear % 4 == 0) {			// Only test potential leap years
			if ((testYear % 400 != 0 ^ testYear % 1000 == 0)) {
				System.out.println(testYear + " is a leap year.");
			} else {
				System.out.println(testYear + " is not a leap year.");
			}
			
		} else {
			System.out.println(testYear + " is not a leap year.");
		}
	
	}

}
