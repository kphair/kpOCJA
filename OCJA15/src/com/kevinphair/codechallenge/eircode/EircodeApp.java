package com.kevinphair.codechallenge.eircode;

import java.util.Scanner;

/* See eircodes.txt for specification and sample database
 */
public class EircodeApp {

	public static void main(String[] args) {
		String userInput;
		String [] eircode = {"D02 Y006", "D04 C932", "D15 XR2R", "D03 RR27", "D24 H510"};
		String [] addresses = {"5 Merrion Square North, Dublin 2", 
								"10 Burlington Road, Dublin 4",
								"Dunsink Observatory, Dunsink Lane, Dublin 15",
								"26 KINCORA ROAD, Clontarf, Dublin 3.",
								"Partas, 4A BROOKFIELD ENTERPRISE CENTRE, Dublin 24"};
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter eircode: ");
		userInput = scan.next();
		System.out.println(userInput);
		
	}

}
