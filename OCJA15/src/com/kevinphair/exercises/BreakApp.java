package com.kevinphair.exercises;

import java.util.Scanner;

public class BreakApp {

	public static void main(String[] args) {

		float targetNumber = 0.0f;
		final float MAX_NUM = 100.0f;
		
		
		System.out.println("This program will count from 1 to 100 in steps of 0.1.");
		System.out.println("Please enter a number you would like to stop at (e.g. 4, 7.2, 42.9, etc.)");

		Scanner scan = new Scanner(System.in);
		do {
			while (! scan.hasNextFloat()) {
				scan.next();
			}
			targetNumber = scan.nextFloat();
			if ((targetNumber < 1) || (targetNumber > MAX_NUM)) {
				// Check to see if the float has only one digit after the decimal point
				if (targetNumber * 10 == (int)(targetNumber * 10)) {
					System.out.println("Seems legit");
					break;
				}
				System.out.println(targetNumber + " is not a valid number. Please try again...");
				targetNumber = 0;
			}
		} while (targetNumber == 0);

		searchloop:
		for (int i = 1; i <= MAX_NUM; ++i) {
			
			System.out.print("Checking " + i + ", ");
			if (i == targetNumber) {
				System.out.println("\nI did it! I found your number, " + i + "!");
				break;
			}
			for (float j = 1; j <= 9; ++j) {
				System.out.println(i + j / 10);
				if (i + j / 10 == targetNumber) {
					System.out.println("\nI did it! I found your number, " + targetNumber + "!");
					break searchloop;
				}
			}
		}
		scan.close();
	}

}
