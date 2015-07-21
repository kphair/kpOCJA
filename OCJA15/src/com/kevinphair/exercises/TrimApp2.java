package com.kevinphair.exercises;

import java.util.Scanner;

/**
 * @author Kevin Phair
 */
public class TrimApp2 {

	/*
	 * Get a string from the user and remove any leading and trailing whitespace
	 * Do this using the Java trim() method and our own made-up one
	 */
	public static void main(String[] args) {

		// Get a string from the user
		String userText = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Please enter some text with NO whitespace on either end and all lower-case:");
		while (userText == "") {
			userText = scan.nextLine();
		}
		System.out.println("\n");		

		
		if (userText.equals(userText.trim())) {
			System.out.println("Java's trim method passes your input");
		} else {
			System.out.println("Java's trim method fails your input");
		}
		if (userText.equals(new TrimApp2().newTrim(userText))) {
			System.out.println("Our trim method passes your input");
		} else {
			System.out.println("Our trim method fails your input");
		}
			

		if (userText.equals(userText.toLowerCase())) { 
			System.out.println("Java's toLowerCase methods passes your input");
		} else {
			System.out.println("Java's toLowerCase methods fails your input");
		}
		if (userText.equals(new TrimApp2().newToLower(userText))) {
			System.out.println("Our newtoLower methods passes your input"); 
		} else {
			System.out.println("Our newtoLower methods fails your input");
		}
		
		scan.close();
	}

	public String newToLower(String test) {
		String newString = "";
		int thisChar;
		
		for (thisChar = 0; thisChar < test.length(); thisChar++) {
			if (test.charAt(thisChar) >= 'A' && test.charAt(thisChar) <= 'Z') {
				newString += (char)(test.charAt(thisChar) + 32);
			} else {
				newString += test.charAt(thisChar);
			}
		}
		return newString;
	}

	public String newTrim(String test) {
		int trimStart = 0;
		int trimEnd = 0;
		
		if (test != null) {
			// Scan the string from the start until the first non-whitespace character is found
			for (trimStart = 0; (trimStart < test.length()) && (test.charAt(trimStart) <= ' '); trimStart++);
				
			// Scan the string backwards from the end until a non-white space character is found
			for (trimEnd = test.length() - 1; (trimEnd > trimStart) && (test.charAt(trimEnd) <= ' '); trimEnd--);
			return test.substring(trimStart, trimEnd + 1);
		} else {
			return null;
		}
	}

}
