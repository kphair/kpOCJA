package com.kevinphair.codechallenge.eircode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	/* 
	 * Set up some globals for reuse between all methods
	 */
	static Scanner scan;
	
	/**
	 * Set up the eircode and address database
	 */
	static StringBuilder[] eircodes;
	static StringBuilder[] addresses;

	/** 
	 * Start of program
	 */
	public static void main(String[] args) {
		StringBuilder userInput;

		if (! loadDataFile("src/com/kevinphair/codechallenge/eircode/EircodeData.txt")) {
			System.out.println("Program terminated");
			return;
		};
		scan = new Scanner(System.in);
		
		mainloop:
		while (true) {
			System.out.println();
			System.out.println("Please select from the following options ");
			System.out.println("1: Search database by eircode");
			System.out.println("2: Search database by address");
			System.out.println("3: Search database by area");
			System.out.println("4: Add new eircode and address");
			System.out.println("5: Dump database to console");
			System.out.println("6: Quit");
			System.out.print("Please enter an option: ");

			while (true) {
				while (!scan.hasNextLine());
				userInput = new StringBuilder(scan.nextLine());

				if (userInput.length() == 1 && userInput.charAt(0) >= '1' && userInput.charAt(0) <= '6'){
					break;	 
				} else {
					System.out.println("Invalid option entered, please try again ");
				}
			}

			switch (userInput.charAt(0)){
				case '1':findByEircode(); break;
				case '2':findByAddress(); break;
				case '3':findByArea(); break;
				case '4':addNewEntry(); break;
				case '5':dumpAll(); break;
				case '6':quit(); break mainloop;
			}
		}
	scan.close();
	}
	
	private static void findByEircode() {
		
		StringBuilder userInput;

		System.out.print("Please enter eircode: ");
		while (true) {
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine().toUpperCase());
			if (userInput.length() == 8 ) break;
			System.out.println("Code needs to be 8 characters in length, you entered '" + userInput + "'");
			System.out.println("Please try again.");
		}
		
		/**
		 * Scan the eircode array for a matching code using an index
		 * to iterate over the array
		 */
		int i = 0;								// Use i as an index into the database
		for (i = 0; i < eircodes.length; i++){
			if(equalsIgnoreCase(new StringBuilder(eircodes[i]), userInput)){
				break;
			}
		}
		// If the index has gone past the end of the string, there was no match
		if (i == eircodes.length){
			System.out.println("Eircode not found");
		} else {
		// We have a match. Get the address from the addresses array using the index 
			System.out.println("Eircode found");
			System.out.println("The address matching to '" + userInput + "' is '" + addresses[i] + "'");
		}
	}

	private static void findByAddress() {
		StringBuilder userInput;

		System.out.print("Please enter part of the address: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() > 0) break;
		}
		
		boolean foundMatch = false;
		for (int i = 0; i < addresses.length; i++){
			if (containsIgnoreCase(new StringBuilder(addresses[i]), userInput)){
				System.out.println("Eircode for " + addresses[i] + " is " + eircodes[i]);
				foundMatch = true;
			}
		}
		
		if (foundMatch == false){
			System.out.println("Address was not found ");
		}
	}

	/**
	 * TBD - Validate the supplied string to see if it's an eircode
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
	public static int validateEircode(StringBuilder eircode) {
		/*
		 * NOT COMPLETE
		 */
		
		if (eircode.length() == 8) {
			return 1;											
		}
		
		return 0;
	}
	
	private static void findByArea() {
		StringBuilder userInput;

		System.out.print("Please enter the first three digits of the eircode: ");
		while(true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 3) break;
			
			System.out.println("'" + userInput + "' is not a valid area code, please try again" );
		}
		
		for (int i = 0; i < eircodes.length; i++){
//			if(addresses[i].contains(userInput.i)
			if (containsIgnoreCase(new StringBuilder(eircodes[i].substring(0, 3)), userInput)){
				System.out.println("Found " + eircodes[i] + " - " + addresses[i]);
			}
		}
	}

	private static void addNewEntry() {
		StringBuilder userInput = null;
		StringBuilder newEircode = null;
		StringBuilder newAddress = null;
		//int i;
		
		scan = new Scanner(System.in);
		System.out.print("Please enter a new eircode or leave blank to return to menu: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 0) {
				return;
			} else if (userInput.length() == 8) {
				break;
			}
			
			System.out.println("'" + userInput + "' is not a valid eircode, please try again" );
		}
		newEircode = userInput;
		
		System.out.print("Please enter new address or nothing to cancel and return to main menu: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 0) {
				return;
			} else if (userInput.length() > 0) {
				break;
			}
			
			System.out.println("'" + userInput + "' is not a valid address, please try again" );
		}

		newAddress = userInput;
		eircodes = extendArray(eircodes);
		addresses = extendArray(addresses);
		eircodes[eircodes.length -1] = new StringBuilder(newEircode);
		addresses[addresses.length -1] = new StringBuilder(newAddress);
	}
	
	private static StringBuilder[] extendArray(StringBuilder[] oldArray){
		StringBuilder[] newArray = new StringBuilder[oldArray.length +1];
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}

	private static void dumpAll() {
		System.out.println("Dump of eircode database");
		System.out.println("------------------------");
		for (int i = 0; i < eircodes.length; i++) {
			System.out.println(eircodes[i] + " - " + addresses[i]);
		}
	}

	private static void quit() {
		System.out.println("Thank you and goodbye.");
	}

	private static boolean equalsIgnoreCase (StringBuilder sb1, StringBuilder sb2) {
		int i;
		char c1;
		char c2;
		
		if (sb1 == sb2) return true;
		if (sb1.length() != sb2.length()) return false;
		if (sb1.length() == 0 && sb2.length() == 0) return true;
		for (i = 0; i < sb1.length(); i++) {
			c1 = sb1.charAt(i);
			if (c1 >= 'a' && c1 <= 'z') c1 -= 32;
			c2 = sb2.charAt(i);
			if (c2 >= 'a' && c2 <= 'z') c2 -= 32;
			if (c1 != c2) return false;
		}
		return true;
	}
	
	private static boolean loadDataFile (String filename) {
		BufferedReader inFile = null;
		StringBuilder newEircode = null;
		StringBuilder newAddress = null;
		StringBuilder inLine = new StringBuilder();
		
		char inChar;
		int readChar;
		
		// open file for input
		try {
			FileReader fr = new FileReader(filename);
			inFile = new BufferedReader(fr);

			// read the first character from the file
			readChar = (char)inFile.read();
			inChar = (char)readChar;

			// Start the loop which goes through the whole file
			while (true) {
				
				if (readChar < 0) break;

				/* If a printable character, append it to the StringBuilder and get another one
				 */
				if (inChar >= ' ') {  
					inLine.append(inChar);
					readChar = (char)inFile.read();
					inChar = (char)readChar;
					
					/* If it's a tab, assign the current StringBuilder to the newEircom StringBuilder
					 * and create a new StringBuilder to hold the next bit of data from the file
					 */
				} else if (inChar == '\t') {		
					newEircode = inLine;
					inLine = new StringBuilder();	
					readChar = (char)inFile.read();
					inChar = (char)readChar;
					
					/* If it's an end of line marker, assign the current StringBuilder to newAddress
					 * and read more characters in until no more EOL characters are found as UNIX/Linux
					 * uses LF to mark and end of line, DOS/Windows uses CR & LF and Mac can use CR or
					 * LF & CR.
					 * Then, extend the eircodes and addresses arrays by one and put the newEircome
					 * and newAddress references into the empty slot at the ends
					 */
				} else if (inChar == 13 || inChar == 10) {		
					System.out.print("Added record: ");
					newAddress = inLine;
					inLine = new StringBuilder();
					do {
						readChar = (char)inFile.read();
						inChar = (char)readChar;
					} while (inChar == 13 || inChar == 10);		
					// Only add the new entry if the Eircode and adddress are valid
					if (validateEircode(newEircode) > 0 && addresses.length > 0) {
						eircodes = extendArray(eircodes);
						eircodes[eircodes.length - 1] = newEircode;
						addresses = extendArray(addresses);
						addresses[addresses.length - 1] = newAddress;
					}
					System.out.println(newEircode + " - " + newAddress);
				} else {
					readChar = (char)inFile.read();
					inChar = (char)readChar;
				}
			}
			inFile.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error opening data file '" + filename + "'");
			return false;
		}
	}

	private static boolean containsIgnoreCase (StringBuilder searchSB, StringBuilder findSB) {

		int i;
		int searchLen = searchSB.length();
		int findLen = findSB.length();
		
		if (searchSB == findSB) return true;
		if (findLen == 0 && searchLen == 0) return true;
		if (findLen == 0 || searchLen == 0 || findLen > searchLen) return false;
		
		for (i = 0; i <= searchLen - findLen; i++) {
			if (equalsIgnoreCase(new StringBuilder(searchSB.subSequence(i, i + findLen)), findSB)) return true;
		}
		return false;
	}
}