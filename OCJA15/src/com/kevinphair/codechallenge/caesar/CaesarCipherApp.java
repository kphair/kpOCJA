package com.kevinphair.codechallenge.caesar;

import java.util.Scanner;

/**
 * @author Kevin, James, Joe
 *
 */
public class CaesarCipherApp {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		mainloop:
			
			while (true) {
				switch (mainMenu()) {
					case 1: System.out.println("Encrypt selected"); 
							encryptString();
							break;
					case 2: System.out.println("Decrypt selected");
							decryptString();
							break;
					case 3: System.out.println("Program quitting. Thank you"); break mainloop;
				};
			}
		

	}

	/**
	 * Shows the main menu and gets option from the user
	 * @return option selected as integer
	 */
	public static int mainMenu() {
		
		int i = 0;
		
		System.out.println("Caesar Cipher");
		System.out.println();
		System.out.println("Choose from one of the following options");
		System.out.println("1: Encrypt a string");
		System.out.println("2: Decrypt a string");
		System.out.println("3: Quit");
		System.out.println();
		System.out.println("Press the number you want to select and press ENTER");
		
		while (true) {
			i = scan.nextInt();
			if (i > 0 && i < 4) {
				break;
			} else {
				System.out.println("That was an invalid choice. Please try again.");
			}
		}
		
		return i;
	}
	
	public static void encryptString() {
	
		String inputString;
		char c;
		
		System.out.println("Please enter some text to encrypt");
		inputString = scan.nextLine();
		
		if (inputString.length() > 0) {
			StringBuffer newString = new StringBuffer(inputString);
			for (int i = 0; i < newString.length(); ++i) {
				c = newString.charAt(i);
				if (c >= 32 && c <= 126) {
					c = (char)(((c - 32) + 1) % 95);
					
				}
			}
		}
	}
	
	public static void decryptString() {
		
	}
	
	
}
