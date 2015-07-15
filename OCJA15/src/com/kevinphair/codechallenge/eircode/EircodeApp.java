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
	static String[] eircodes = {
								new StringBuilder("D02 Y006"),
								"D04 C932",
								"D15 XR2R",
								"D03 RR27", 
								"D24 H510",
								"D02 XE81",
								"D02 P656"
								};
	static String[] addresses = {
								"5 Merrion Square North, Dublin 2", 
								"10 Burlington Road, Dublin 4",
								"Dunsink Observatory, Dunsink Lane, Dublin 15",
								"26 KINCORA ROAD, Clontarf, Dublin 3.",
								"Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24",
								"HODGES FIGGIS, 56-58 DAWSON STREET, Dublin 2",
								"CENTRAL BANK OF IRELAND, DAME STREET, Dublin 2"
								};

	/** 
	 * Start of program
	 */
	public static void main(String[] args) {
		StringBuilder userInput;

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
		/*
		 * NOT COMPLETE
		 */
		if (eircode.length() < 7 || eircode.length() > 8) {
			return 0;											// No match
		}
		
		if ((eircode.length() == 8) || (eircode.replace(" ", "").length() == 7)) {
			
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
		StringBuilder userInput;
		StringBuilder newEircode;
		StringBuilder newAddress;
		//int i;
		
		scan = new Scanner(System.in);
		System.out.print("Please enter a new eircode : ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() == 8) break;
			
			System.out.println("'" + userInput + "' is not a valid eircode, please try again" );
		}
		newEircode = userInput;
		
		System.out.print("Please enter a new address : ");
		while (true){
			while (!scan.hasNextLine());
			userInput = new StringBuilder(scan.nextLine());
			if (userInput.length() > 0) break;
			
			System.out.println("'" + userInput + "' is not a valid address, please try again" );
		}

		newAddress = userInput;
		eircodes = extendArray(eircodes);
		addresses = extendArray(addresses);
		eircodes[eircodes.length -1] = new String(newEircode);
		addresses[addresses.length -1] = new String(newAddress);
	}
	
	private static String[] extendArray(String[] oldArray){
		String[] newArray = new String[oldArray.length +1];
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
	
	private static void loadDataBase (String filename) {
		BufferedReader inFile = null;
		StringBuilder newEircode;
		StringBuilder newAddress;
		StringBuilder inLine = new StringBuilder();
		
		char inChar;
		
		// open file for input
		try {
			FileReader fr = new FileReader(filename);
			inFile = new BufferedReader(fr);
			//inString = inFileP.
		} catch (IOException e) {
			e.printStackTrace();
		}

		// start reading data from the file
		if (inFile != null) {
			try {
				// read the file in character by character
				while (true) {
					// Read a character from the file
					inChar = (char)inFile.read();
					// Is it a printable character?
					if (inChar >= ' ') { 
						inLine.append(inChar);
					// Is it a tab?
					} else if (inChar == '\t') {
						
					// Is it a carriage return or line-feed?
					} else if (inChar == 13 || inChar == 10) { 
						
					}
					
					if ((int)inChar < 0) break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inFile != null) {
					inFile.close();
				}
			}
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