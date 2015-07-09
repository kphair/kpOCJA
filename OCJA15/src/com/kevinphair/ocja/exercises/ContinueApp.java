package com.kevinphair.ocja.exercises;

public class ContinueApp {

	public static void main(String[] args) {
		
		System.out.println("Printing odd numbers from 10 to 100 (using continue)");
		for (int i = 10; i <= 100; ++i) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println("\n");
		
		System.out.println("Printing even numbers from 10 to 100 (using continue)");
		for (int i = 10; i <= 100; ++i) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println("\n");

		System.out.println("Printing odd numbers from 10 to 100 (using if)");
		for (int i = 10; i <= 100; ++i) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
		
		System.out.println("Printing even numbers from 10 to 100 (using if)");
		for (int i = 10; i <= 100; ++i) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
	}
}
