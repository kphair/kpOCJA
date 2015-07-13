package com.kevinphair.ocja.exercises;

import java.util.Scanner;

/**
 * @author Kevin Phair
 */
public class TrimApp {

	/*
	 * Get a string from the user and remove any leading and trailing whitespace
	 * Do this using the Java trim() method and our own made-up one
	 */
	public static void main(String[] args) {

		// Get a string from the user
		String userText = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Please enter some text which needs whitespace cleaned off each end:");
		while (userText == "") {
			userText = scan.nextLine();
		}
		System.out.println("\n");		
		
		System.out.println("Below is the text as you entered it:");
		System.out.println("'" + userText + "'\n");
		
		System.out.println("Here it is cleaned up:");
		System.out.println("'" + userText.trim() + "'\n");
		
		System.out.println("Now here it is using a custom trim method:");
		System.out.println("'" + new TrimApp().newTrim(userText) + "'");
		
		scan.close();
	}

	public String newTrim(String test) {
		
		int trimStart = 0;
		int trimEnd = 0;
		
		if (test != null) {
			// Scan the string from the start until the first non-whitespace character is found
			for (trimStart = 0; (trimStart < test.length()) && (test.charAt(trimStart) <= ' '); trimStart++);
				
			// Scan the string backwards from the end until a non-white space character is found
			for (trimEnd = test.length() - 1; (trimEnd > trimStart) && (test.charAt(trimEnd) <= ' '); trimEnd--);
		}
		return test.substring(trimStart, trimEnd + 1);
	}
}
