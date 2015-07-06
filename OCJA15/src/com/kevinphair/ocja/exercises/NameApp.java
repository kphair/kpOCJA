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
			userName = scan.next();
			System.out.println(userName);
		}
		
		System.out.println("Print to console 100 times using for() loop:");
		for (int i = 0; i < 100; ++i) {
			System.out.print(i + ":" + userName + "  ");
		}
		System.out.println();
		
		
	}
}
