package com.kevinphair.ocja.exercises;

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
		if (isEven(numForTesting) == false) {
			System.out.println("Is the number prime? " + isPrime(numForTesting));
		}

	}

	private static boolean isEven(int testNum) {

		return (testNum % 2 == 0);
	}

	private static boolean isPrime(int testNum) {

		if (Math.abs(testNum) > 3) {
			for (int i = 3; i < testNum; i+= 2) {
				if ((float)testNum / (float)i == testNum / i)
					return false;
			}
		} else if (testNum == 3) {
			return true;
		} else {
			return false;
		}
		return true;
	}
}
