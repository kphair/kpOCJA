package com.kevinphair.codechallenge.eircode;

import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	public static void main(String[] args) {
		String userInput;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter eircode: ");
		userInput = scan.next();
		System.out.println(userInput);
		
	}

}
