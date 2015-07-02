package com.kevinphair.ocja.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IfStatementApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int menuOption = 0;
		String userName = "";
		int userAge = 0;
		
		mainmenu:
		while (true) {
			if (userName != "") {
				System.out.print("Hello, " + userName + ". ");
			}
			System.out.println("Please type in the number matching the option you want to select below and press ENTER\n");
			System.out.println("1:   Enter your name");
			System.out.println("2:   Enter your age");
			System.out.println("3:   Quit");

			try {
				menuOption = scan.nextInt();
				if (menuOption == 1) {
					System.out.println("Please enter your name and press ENTER: ");
					userName = scan.next();
				} else if (menuOption == 2) {
					System.out.println("Please enter your age and press ENTER: ");
					userAge = scan.nextInt();
				} else if (menuOption == 3) {
					System.out.println("Thank you " + (userName != "" ? userName + " " : "") 
							+ "for using SkyNet by Cyberdyne systems.");
					System.out.println("The machine war began " 
									+ (userAge == 0 ? "in 1997." : (userAge - 18) + " years ago."));
					System.out.println();
					break mainmenu;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid option selected. Please try again.");
			}
		}
	}
}
