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
			if (userInput.length() == 8) break;
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
			System.out.println(addresses[i]);
		}
	}

}
