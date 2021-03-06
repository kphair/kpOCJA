package com.kevinphair.exercises;

import java.util.Scanner;

public class ReturnApp {

	public static void main(String[] args) {

		int numForTesting = 0;

		System.out.println("Please enter a number for even/odd/prime testing");

		Scanner scan = new Scanner(System.in);
		while (! scan.hasNextInt()) {
			scan.next();
		}
		numForTesting = scan.nextInt();
		System.out.println("Is the number even? " + isEven(numForTesting));
		if (! isEven(numForTesting)) {
			System.out.println("Is the number prime? " + isPrime(numForTesting));
		} else {
			System.out.println("Not a prime number");
		}

	}

	private static boolean isEven(int testNum) {

		return (testNum % 2 == 0);
	}

	private static boolean isPrime(int testNum) {

		if (Math.abs(testNum) > 3) {
			for (int i = 3; i < (testNum / 2); i+= 2) {
				if (testNum % i == 0) return false;
			}
		} else if (testNum == 3) {
			return true;
		} else {
			return false;
		}
		return true;
	}
}
