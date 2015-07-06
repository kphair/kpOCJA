package com.kevinphair.ocja.exercises;

import java.util.Scanner;

public class NameApp {

	public static void main(String[] args) {

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

		String userName = "";
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter your name:");
		
		while (userName == "") {
			userName = scan.nextLine();
		}
		System.out.println("\n");
		
		System.out.println("Print to console 100 times using for() loop:");
		for (int i = 0; i < 100; ++i) {
			System.out.print(i + ":" + userName + "  ");
		}
		System.out.println("\n");

//		String emanResu = "";
//		for (int i = userName.length() - 1; i >= 0; --i) {
//			emanResu += userName.charAt(i);
//		}
		
		String emanResu = new StringBuilder(userName).reverse().toString();
		
		System.out.println("Print name backwards to console 100 times using for() loop:");
		for (int i = 0; i < 100; ++i) {
			System.out.print(i + ":" + emanResu + "  ");
		}
		System.out.println("\n");
		
	}
}
