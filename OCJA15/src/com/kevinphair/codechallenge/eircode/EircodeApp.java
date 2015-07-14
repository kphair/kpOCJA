package com.kevinphair.codechallenge.eircode;

import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	public static void main(String[] args) {
		String userInput;
		
		/*
		 * Set up the eircode and address database
		 */
		String [] eircodes = {"D02 Y006", "D04 C932", "D15 XR2R", "D03 RR27", "D24 H510"};
		String [] addresses = {"5 Merrion Square North, Dublin 2", 
								"10 Burlington Road, Dublin 4",
								"Dunsink Observatory, Dunsink Lane, Dublin 15",
								"26 KINCORA ROAD, Clontarf, Dublin 3.",
								"Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24"};
		
		
		/* create a new Scanner object to get user input
		 * prompt user for input and get input to string
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter eircode: ");
		while(true) {
			userInput = scan.nextLine().toUpperCase();
			if (userInput.length() == 8 ) break;
			System.out.println("Code needs to be 8 characters in length, you entered '" + userInput + "'");
			System.out.println("Please try again.");
		}
		scan.close();							// Scanner no longer needed
		
		/*
		 * Scan the eircode array for a matching code using an index
		 * to iterate over the array
		 */
		int i = 0;								// Use i as an index into the database
		for(i = 0; i < eircodes.length; i++){
			if(eircodes[i].equals(userInput)){
				break;
			}
		}
		// If the index has gone past the end of the string, there was no match
		if(i == eircodes.length){
			System.out.println("Eircode not found");
		}
		// We have a match. Get the address from the addresses array using the index 
		else{
			System.out.println("Eircode found");
			System.out.println("The address matching to '" + userInput + "' is '" + addresses[i] + "'");
		}
	}
	
	/*
	 * Validate the supplied string to see if it's an eircode
	 * Assumptions:
	 * If the string is 8 characters, it should have a space as the 4th character
	 * If the string is 7 characters, it should have no spaces in it
	 * If the string is less than 7 or more than 8 it will considered invalid
	 * If the string is 8 characters, it will be assumed that the space could be anywhere for a close match
	 * 
	 * @returns 0 for no match, 1 for a close match, 2 for a perfect match
	 * 
	 */
	public int validateEircode(String eircode) {
		
		if (eircode.length() < 7 || eircode.length() > 8) {
			return 0;											// No match
		}
		
		if (eircode.length() == 8) || eircode.replace(" ", "" != 7) {
			
		}
		
	}

}
