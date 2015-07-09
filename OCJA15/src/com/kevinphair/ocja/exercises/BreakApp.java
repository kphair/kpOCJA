package com.kevinphair.ocja.exercises;

import java.util.Scanner;

public class BreakApp {

	public static void main(String[] args) {

		int targetNumber = 0;
		final int MAX_NUM = 100;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("This program will count from 1 to 100.");
		System.out.println("Please enter a number you would like to stop at.");
		do {
			while (! scan.hasNextInt()) {
				scan.next();
			}
			targetNumber = scan.nextInt();
			if ((targetNumber < 1) || (targetNumber > MAX_NUM)) {
				System.out.println(targetNumber + " is an invalid number. Please try again...");
				targetNumber = 0;
			}
		} while (targetNumber == 0);

		
		for (int i = 1; i <= MAX_NUM; ++i) {
			
			System.out.print("Checking " + i + ", ");
			if (i == targetNumber) {
				System.out.println("\nI did it! I found your number, " + i + "!");
				break;
			}
			for (int j = 1; j <= 9; ++j) {
				System.out.print(i + "." + j + (j < 9 ? ", " : "\n"));
			}
		}

	}

}
