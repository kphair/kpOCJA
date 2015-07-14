package com.kevinphair.codechallenge.eircode;

import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	static String userInput;
	static String addressInput;
	static Scanner scan;
	
	/**
	 * Set up the eircode and address database
	 */
	
	static String [] eircodes = {"D02 Y006", "D04 C932", "D15 XR2R", "D03 RR27", "D24 H510", "D02 XE81", "D02 P656"};
	static String [] addresses = {"5 Merrion Square North, Dublin 2", 
			"10 Burlington Road, Dublin 4",
			"Dunsink Observatory, Dunsink Lane, Dublin 15",
			"26 KINCORA ROAD, Clontarf, Dublin 3.",
	"Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24",
			"HODGES FIGGIS, 56-58 DAWSON STREET, Dublin 2",
			"CENTRAL BANK OF IRELAND, DAME STREET, Dublin 2"};
	public static void main(String[] args) {
		
		

// 		display "1: Search database by eircode"
// 		display "2: Search database by address"
// 		display "3: Search database by area"
// 		display "4: Add new eircode and address"
// 		display "5: Dump database to console"
// 		display "6: Quit"
		
		System.out.println("Please select from the following options ");
		System.out.println("1: Search database by eircode");
		System.out.println("2: Search database by address");
		System.out.println("3: Search database by area");
		System.out.println("4: Add new eircode and address");
		System.out.println("5: Dump database to console");
		System.out.println("6: Quit");
		
		 scan = new Scanner(System.in);
		 System.out.print("Please enter an option: ");
		 
		 while(true) {
			 userInput = scan.nextLine();
			 
			 if(userInput.length() == 1 && userInput.charAt(0) >= '1' && userInput.charAt(0) <= '6'){
				break;	 
			 }
			 else{
				 System.out.println("Invalid option entered, please try again ");
			 }
					 
		 }
		 
		 switch(userInput){
			 case "1":findByEircode(); break;
			 case "2":findByAddress(); break;
			 case "3":findByArea(); break;
			 case "4":addNewEntry(); break;
			 case "5":dumpAll(); break;
			 case "6":quit(); break;
		 }
	}
	
	private static void dumpAll() {
		// TODO Auto-generated method stub
		
	}

	private static void quit() {
		// TODO Auto-generated method stub
		
	}

	private static void addNewEntry() {
		// TODO Auto-generated method stub
		String newEircode;
		String newAddress;
		int i;
		
		scan = new Scanner(System.in);
		System.out.print("Please enter a new eircode : ");
		while(true){
			userInput = scan.nextLine();
			if(userInput.length() == 8) break;
			
			System.out.println("'" + userInput + "' is not a valid eircode, please try again" );
		}
		scan.close();
		newEircode = userInput;
		
		scan = new Scanner(System.in);
		System.out.print("Please enter a new address : ");
		while(true){
			userInput = scan.nextLine();
			if(userInput.length() > 0) break;
			
			System.out.println("'" + userInput + "' is not a valid address, please try again" );
		}
		scan.close();
		newAddress = userInput;
		eircodes = extendArray(eircodes);
		addresses = extendArray(addresses);
		eircodes[eircodes.length -1] = newEircode;
		addresses[addresses.length -1] = newAddress;
	}
	
	private static String [] extendArray(String [] oldArray){
		String [] newArray = new String[oldArray.length +1];
		for(int i = 0; i < oldArray.length; i++){
			newArray[i] = oldArray[i];
		}
		return newArray;
		
	}

	private static void findByArea() {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		System.out.print("Please enter the first three digits of the eircode: ");
		while(true){
			userInput = scan.nextLine();
			if(userInput.length() == 3) break;
			
			System.out.println("'" + userInput + "' is not a valid area code, please try again" );
		}
		scan.close();
		
		int i;
		
		for(i = 0; i < eircodes.length; i++){
//			if(addresses[i].contains(userInput.i)
			if(eircodes[i].substring(0, 3).toLowerCase().contains(userInput.toLowerCase())){
				System.out.println("Found " + eircodes[i] + " - " + addresses[i]);
			}
		}
		
	}

	private static void findByAddress() {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		System.out.print("Please enter part of the address: ");
		while(true){
			userInput = scan.nextLine();
			if(userInput.length() > 0) break;
			}
		scan.close();
		
		int i;
		
		for(i = 0; i < addresses.length; i++){
//			if(addresses[i].contains(userInput.i)
			if(addresses[i].toLowerCase().contains(userInput.toLowerCase())){
				break;
			}
		}
		
		if(i == addresses.length){
			System.out.println("Address was not found ");
		}
		else{
			System.out.println("Eircode for " + addresses[i] + " is " + eircodes[i]);
		}
		
		
	}

	private static void findByEircode() {
		// TODO Auto-generated method stub
		/**
		 *  create a new Scanner object to get user input
		 * prompt user for input and get input to string
		 */
		scan = new Scanner(System.in);
		System.out.print("Please enter eircode: ");
		while(true) {
			userInput = scan.nextLine().toUpperCase();
			if (userInput.length() == 8 ) break;
			System.out.println("Code needs to be 8 characters in length, you entered '" + userInput + "'");
			System.out.println("Please try again.");
		}
		scan.close();							// Scanner no longer needed
		
		/**
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

	/**
	 * Validate the supplied string to see if it's an eircode
	 * Assumptions:
	 * If the string is 8 characters, it should have a space as the 4th character
	 * If the string is 7 characters, it should have no spaces in it
	 * If the string is less than 7 or more than 8 it will considered invalid
	 * If the string is 8 characters, it will be assumed that the space could be anywhere for a close match
	 * 
	 * @param string for checking
	 * @returns 0 for no match, 1 for a close match, 2 for a perfect match
	 * 
	 */
	public int validateEircode(String eircode) {
		
		if (eircode.length() < 7 || eircode.length() > 8) {
			return 0;											// No match
		}
		
		if ((eircode.length() == 8) || (eircode.replace(" ", "").length() == 7)) {
			
		}
		return 0;
	}

}
