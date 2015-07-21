package com.kevinphair.exercises;

import java.util.Scanner;

public class NameApp {

	public static void main(String[] args) {

		// Brute-force print string 10 times
		System.out.println("Print to console 10 times with no lopp:");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.print("  Kevin");
		System.out.println();

		// Get a string from the user
		String userName = "";
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter your name:");
		while (userName == "") {
			userName = scan.nextLine();
		}
		System.out.println("\n");

		// Print the string 100 times
		System.out.println("Print to console 100 times using for() loop:");
		for (int i = 0; i < 100; ++i) {
			System.out.print(i + ":" + userName + "  ");
		}
		System.out.println("\n");

		// Print it backwards 100 times
		System.out.println("Print name backwards to console 100 times using for() loop:");
		/*
		String emanResu = "";
		for (int i = userName.length() - 1; i >= 0; --i) {
			emanResu += userName.charAt(i);
		}
		*/
		String emanResu = new StringBuilder(userName).reverse().toString();
		for (int i = 0; i < 100; ++i) {
			System.out.print(i + ":" + emanResu + "  ");
		}
		System.out.println("\n");
		
		// Demonstrate the for-each (aka for-in) construct
		System.out.println("Displaying items in an array using the for-each or for-in construct");
		String[] nobelNames = {"Einstein", "Feynman", "Heisenberg", "Schrodinger", "Bohr" };
		for (String s : nobelNames) {
			System.out.print(s);
		}
		
	}
}
