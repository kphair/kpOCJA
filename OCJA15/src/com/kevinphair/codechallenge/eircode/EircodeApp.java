package com.kevinphair.codechallenge.eircode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	/* Set up some globals for reuse between all methods
	 */
	static Scanner scan;
	
	/* Set up the eircode and address database
	 */
	static StringBuilder[] eircodes = new StringBuilder[0];
	static StringBuilder[] addresses = new StringBuilder[0];
	static boolean dataModified = false;

	/** 
	 * Application to query and maintain a database of Eircodes with matching addresses
	 */
	public static void main(String[] args) {
		String filename = "src/com/kevinphair/codechallenge/eircode/EircodeData.txt";

		/* 
		 * Attempt to read in the database and terminate if there was an error
		 */
		if (! loadDataFile(filename)) {
			System.out.println("Error accessing data file '" + filename + "'");
			System.out.println("Program terminated");
			return;
		};
		
		System.out.println(eircodes.length + " records read from data file.");
		
		scan = new Scanner(System.in);
		
		mainloop:
		while (true) {
			
			displayMenu();

			switch (getMenuChoice()){
				case '1':	findByEircode(); break;
				case '2':	findByAddress(); break;
				case '3':	findByArea(); break;
				case '4':	dataModified = addNewEntry(); break;
				case '5':	dumpAll(); break;
				case '6':	quit();
							if (dataModified && (writeDataFile(filename) == false)) {
								System.out.println("* There was an error writing the new database, '" + filename + "'");
								break;
							}
							break mainloop;
			} // end of menu choice switch block 
		}
		scan.close();
	}

	/**
	 * Get input from the user and return the first character
	 * 
	 * @return a character from '1' to '6' entered by the user
	 */
	private static char getMenuChoice() {
		StringBuilder userInput;

		while (true) {
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());

			if (userInput.length() == 1 && userInput.charAt(0) >= '1' && userInput.charAt(0) <= '6'){
				break;	 
			} else {
				System.out.println("Invalid option entered, please try again ");
			}
		}
		return userInput.charAt(0);
	}

	/**
	 * Display the main menu
	 */
	private static void displayMenu() {
		System.out.println();
		System.out.println("Please select from the following options ");
		System.out.println("1: Search database by eircode");
		System.out.println("2: Search database by address");
		System.out.println("3: Search database by area");
		System.out.println("4: Add new eircode and address");
		System.out.println("5: Dump database to console");
		if (dataModified) {
			System.out.println("6: Write changes to disk and quit");
		} else {
			System.out.println("6: Quit");
		}
		System.out.print("Please enter an option: ");
	}
	
	/**
	 * Allows the user to do a search on the full Eircode
	 */
	private static void findByEircode() {
		
		StringBuilder userInput;

		System.out.print("> Please enter eircode: ");
		while (true) {
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine().toUpperCase());
			if (userInput.length() == 8 ) break;
			System.out.println("  Code needs to be 8 characters in length, you entered '" + userInput + "'");
			System.out.println("  Please try again.");
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
			System.out.println("  Eircode not found");
		} else {
		// We have a match. Get the address from the addresses array using the index 
			System.out.println("* Eircode found");
			System.out.println("  The address matching to '" + userInput + "' is '" + addresses[i] + "'");
		}
	}

	/**
	 * Allows user to enter a search string for partial matches on addresses
	 */
	private static void findByAddress() {
		StringBuilder userInput;

		System.out.print("> Please enter part of the address: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() > 0) break;
		}
		
		boolean foundMatch = false;
		for (int i = 0; i < addresses.length; i++){
			if (containsIgnoreCase(new StringBuilder(addresses[i]), userInput)){
				System.out.println("- Eircode for " + addresses[i] + " is " + eircodes[i]);
				foundMatch = true;
			}
		}
		
		if (foundMatch == false){
			System.out.println("  Address was not found ");
		}
	}

	/**
	 * Allows the user to search by the area (first 3 characters of Eircode)
	 */
	private static void findByArea() {
		StringBuilder userInput;

		System.out.print("> Please enter the first three digits of the eircode: ");
		while(true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 3) break;
			
			System.out.println("* '" + userInput + "' is not a valid area code, please try again" );
		}
		
		for (int i = 0; i < eircodes.length; i++){
//			if(addresses[i].contains(userInput.i)
			if (containsIgnoreCase(new StringBuilder(eircodes[i].substring(0, 3)), userInput)){
				System.out.println("- Found " + eircodes[i] + " - " + addresses[i]);
			}
		}
	}

	/**
	 * Allows the user to add a new entry to the eircode and address database
	 */
	private static boolean addNewEntry() {
		StringBuilder userInput = null;
		StringBuilder newEircode = null;
		StringBuilder newAddress = null;
		
		scan = new Scanner(System.in);
		System.out.print("> Please enter a new eircode or leave blank to return to menu: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 0) {
				return false;
			} else if (userInput.length() == 8) {
				break;
			}
			
			System.out.println("* '" + userInput + "' is not a valid eircode, please try again" );
		}
		newEircode = userInput;
		
		System.out.print("> Please enter new address or nothing to cancel and return to main menu: ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 0) {
				return false;
			} else if (userInput.length() > 0) {
				break;
			}
			
			System.out.println("* '" + userInput + "' is not a valid address, please try again" );
		}

		newAddress = userInput;
		addRecord(newEircode, newAddress);
		
		return true;
	}

	/**
	 * Add a record to the data arrays and populate the new record with Eircode and address
	 * 
	 * @param newEircode
	 * @param newAddress
	 */
	private static void addRecord(StringBuilder newEircode, StringBuilder newAddress) {
		// Create new arrays with 1 extra element each
		eircodes = Arrays.copyOf(eircodes, eircodes.length + 1);
		addresses = Arrays.copyOf(addresses, addresses.length + 1);
		eircodes[eircodes.length -1] = new StringBuilder(newEircode);
		addresses[addresses.length -1] = new StringBuilder(newAddress);
	}
	
	/**
	 * Dump the current database to the console
	 */
	private static void dumpAll() {
		System.out.println("Dump of eircode database");
		System.out.println("------------------------");
		for (int i = 0; i < eircodes.length; i++) {
			System.out.println(eircodes[i] + " - " + addresses[i]);
		}
	}

	/**
	 * Do any housekeeping before the program terminates
	 */
	private static void quit() {
		System.out.println("Thank you and goodbye.");
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
		 * The following letter to number mappings should occur where a disallowed letter appears
		 *	B	-> 8	|	G	-> 6	|	IJL	-> 1	|	M	-> N
		 *	OQ	-> 0	|	S	-< 5	|	U	-> V	|	Z	-> 2
		 */
		final String validChars = "0123456789ACDEFHKNPRTVWXY";
				
		/* 
		 * If string is 8 characters and has a space at position 3, it's OK
		 */
		if (eircode.length() == 8 && eircode.charAt(3) == ' ') return 1;											
		
		/*
		 * If the string has 7 character and has NO spaces, it's OK
		 */
		if ((eircode.length() == 7) && (eircode.indexOf(" ") == -1)) return 0;
		
		return 0;
	}

	/**
	 * Loads the database in from the specified file
	 * 
	 * @param filename of tab delimited text file with one record per line
	 * @return true if successful, false otherwise
	 */
	private static boolean loadDataFile (String filename) {
		BufferedReader inFile = null;
		StringBuilder newEircode = null;
		StringBuilder newAddress = null;
		StringBuilder inLine = new StringBuilder();
		
		int inChar;
		
		// open file for input
		try {
			FileReader fr = new FileReader(filename);
			inFile = new BufferedReader(fr);

			// read the first character from the file
			inChar = inFile.read();

			// Start the loop which goes through the whole file
			while (true) {
				
				/* If a printable character, append it to the StringBuilder and get another one
				 */
				if (inChar >= 32) {  
					inLine.append((char)inChar);
					inChar = inFile.read();
					
				/* If it's a tab, assign the current StringBuilder to the newEircom StringBuilder
				 * and create a new StringBuilder to hold the next bit of data from the file
				 */
				} else if (inChar == '\t') {		
					newEircode = inLine;
					inLine = new StringBuilder();	
					inChar = inFile.read();
					
				/* If end of line marker or end of file, assign current StringBuilder to newAddress
				 * and read more characters in until no more EOL characters are found as UNIX/Linux
				 * uses LF to mark and end of line, DOS/Windows uses CR & LF and Mac can use CR or
				 * LF & CR.
				 * Then, extend the eircodes and addresses arrays by one and put the newEircome
				 * and newAddress references into the empty slot at the ends
				 */
				} else if (inChar == 13 || inChar == 10 || inChar == -1) {		
					newAddress = inLine;
					inLine = new StringBuilder();
					// Skip over any additional line terminators
					while (inChar == 13 || inChar == 10) {		
						inChar = inFile.read();
					}
					// Only add the new entry if the Eircode and adddress are valid
					if (validateEircode(newEircode) > 0) {
						addRecord(newEircode, newAddress);
					}
					if (inChar == -1) {
						break;
					}
				
					/* Otherwise go and read another character from the file
					 */
				} else {
					inChar = inFile.read();
				}
			}
			inFile.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Loads the database in from the specified file
	 * 
	 * @param filename of tab delimited text file with one record per line
	 * @return true if successful, false otherwise
	 */
	private static boolean writeDataFile (String filename) {
		FileWriter outFile = null;
		
		// Rename the old data file so it exists as a backup
		File oldFile = new File(filename);
		File oldFileBackup = new File(filename + "$$$");
		oldFileBackup.delete();
		if (!oldFile.renameTo(oldFileBackup)) {
			System.out.println("Error backing up current databse.");
			return false;
		}

		// open file for input
		try {
			
			File newFile = new File(filename);
            outFile = new FileWriter(newFile, false);
            
            for (int i = 0; i < eircodes.length; ++i) {
       	 		outFile.write(eircodes[i] + "\t" + addresses[i] + "\r\n");
			}
			outFile.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * Provide a method to compare the contents two StringBuilder objects
	 * 
	 * @param first StringBuilder
	 * @param second StringBuilder
	 * @return true if both are equal, false otherwise
	 */
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
	
	/**
	 * Provides a method to see if a StrinBuilder string is contained in another StringBuilder
	 * 
	 * @param StringBuilder to check
	 * @param string to search for
	 * @return true if the searched for string is in the checked one, false otherwise
	 */
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
