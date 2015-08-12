package nu.xdi.code_challenges;

import java.util.Scanner;

public class Exceptions {

	Scanner scan = new Scanner (System.in);

	String userName = "";
	String userPPSN = "";
	String userDOB = "";

	public static void main (String[] args) {

		new Exceptions().startProgram();

	}

	public void startProgram() {

		while (userName.length() == 0) {

			// Get user name
			System.out.print ("Enter a name in the format \"Firstname Lastname\": ");
			userName = scan.nextLine();

			// Validate name
			try {
				validateName (userName);
				System.out.println ("You entered '" + userName + "'\n");
			} catch (InvalidNameException ine) {
				System.out.println ("Invalid name entered. Please try again.");
				userName = "";
			}	

	    }

		while (userPPSN.length() == 0) {

			// Get user PPSN
			System.out.print ("Enter a PPSN as 7 digits followed by a capital letter from the range A-W: ");
			userPPSN = scan.nextLine();
	
			// Validate PPSN
			try {
				validatePPSN (userPPSN);
				System.out.println ("You entered '" + userPPSN + "'\n");
			} catch (InvalidPPSNException ipe) {
				System.out.println ("Invalid PPSN entered (" + ipe + "). Please try again.");
				userPPSN = "";
			}	
	
		}
	
		while (userDOB.length() == 0) {

			// (Optional) Get user date of birth
			System.out.print ("Enter a date in the format dd-mm-yyyy: ");
			userDOB = scan.nextLine();
	
			// Validate DoB
			try {
				validateDate (userDOB);
				System.out.println ("You entered '" + userDOB + "'\n");
			} catch (InvalidDateException ide) {
				System.out.println ("Invalid date entered. Please try again.");
				userDOB = "";
			}	
	
		}

		System.out.println ("\nThank you. The data you entered is as follows:");
		System.out.println ("         Name: " + userName);
		System.out.println ("         PPSN: " + userPPSN);
		System.out.println ("Date of birth: " + userDOB);

	}

	/**
	 * Validate a name
	 * Must have a space somewhere in the middle
	 * All characters must be alpha characters
	 * First character of each name should be upper case,
	 * everything else lower case
	 * 
	 * @param string with name for checking
	 * @throws InvalidNameException if not suitable
	 */
	public void validateName (String name) throws InvalidNameException {

		int foundSpace = 0;
		int nameLen = name.length();
		String firstName = "";
		String lastName = "";

		if (nameLen < 3) {
			throw new InvalidNameException();
		}

		for (int i = 0; i < nameLen; ++i) {

			char c = name.charAt(i);

			if (c == ' ') {
				if (i == 0 || i == nameLen - 1 || foundSpace > 0) {
					throw new InvalidNameException("Space at start or end of name not allowed. Only one space allowed.");
				} else {
					foundSpace = i;
					firstName = name.substring(0,i);
					String goodFirstName = firstName.toUpperCase().charAt(0) + firstName.toLowerCase().substring(1,firstName.length());
					if (!firstName.equals(goodFirstName)) throw new InvalidNameException("First name must have only the first letter in upper case");
				}	
			} else if (i == nameLen - 1) {
				if (foundSpace == 0) {
					throw new InvalidNameException();
				} else {
					lastName = name.substring(foundSpace + 1, nameLen);
					String goodLastName = lastName.toUpperCase().charAt(0) + lastName.toLowerCase().substring(1,lastName.length());
					if (!lastName.equals(goodLastName)) throw new InvalidNameException("Last name must have only the first letter in upper case");
				}	
			}	

		}

	}

	/**
	 * Check a PPSN to make sure it's valid
	 * 7 digits and one check character.
	 * Digit weighting goes from 8 to 2 (left to right) and check character is modulus 23 of the sum.
	 * 
	 * @param string with PPSN for checking
	 * @throws InvalidPPSNException if not valid
	 */
	public void validatePPSN (String ppsn) throws InvalidPPSNException {

		if (ppsn.length() != 8) throw new InvalidPPSNException();

		for (int i = 0; i < 7; ++i) {
			if (ppsn.charAt(i) < '0' || ppsn.charAt(i) > '9') throw new InvalidPPSNException("The first 7 characters must all be digits");
		}

		int w = 8;
		int sum = 0;
		for (int i = 0; i < 7; ++i) {
			sum += Integer.parseInt(ppsn.charAt(i) + "") * w--; 
		}
		char cd = (char)('A' + (sum - 1) % 23);
		if (ppsn.charAt(7) != cd) throw new InvalidPPSNException("The last character is not valid. Should be '" + cd + "'");

	}

	/**
	 * Check date to make sure it's valid and within range.
	 * 
	 * @param string with date for checking
	 * @throws InvalidDateException if not a valid date
	 */
	public void validateDate (String date) throws InvalidDateException {

		String dateFields[] = date.split("-");
		int day = 0;
		int month = 0;
		int year = 0;

		if (dateFields.length != 3) throw new InvalidDateException("There must be three fields in date string");

		try {
			day = Integer.parseInt (dateFields[0]);
			month = Integer.parseInt (dateFields[1]);
			year = Integer.parseInt (dateFields[2]);
		} catch (NumberFormatException nfe) {
			throw new InvalidDateException("One of the fields is not a valid number");
		}

		// Do a simple check of day, month and year ranges

		if (!(day + "").equals(dateFields[0]) || day < 1 || day > 31) {
			throw new InvalidDateException("Error in day");
		}

		if (!(month + "").equals(dateFields[1]) || month < 1 || month > 12) {
			throw new InvalidDateException("Error in month");
		}

		if (!(year + "").equals(dateFields[2]) || year < 0 || year >= 2015) {
			throw new InvalidDateException("Error in year");
		}

		// Is it February?
		if (month == 2) {

			// If year is a leap year, check for month being february and day being valid

			if ((year % 4 == 0) && (year % 100 == 0 && year % 400 == 0)) {

					// Is a leap year, February can go up to 29 days
					if (day > 29) throw new InvalidDateException("February only has 29 days in a leap year");

			} else if (day > 28) {
			
				throw new InvalidDateException("February only has 28 days in non-leap years");
			}	

		// Otherwise, check for 31 days being in the applicable months
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 31) {

			if (day > 31) throw new InvalidDateException("Specified month can only have 31 days");

		// and 30 days being in the others
		} else {

			if (day > 30) throw new InvalidDateException("Specified month can only have 30 days");
		}

	}

}	

class InvalidNameException extends Exception {
	InvalidNameException () { super(); };
	InvalidNameException (String s) { super(s);}	
}

class InvalidPPSNException extends Exception {
	InvalidPPSNException () { super(); }
	InvalidPPSNException (String s) { super(s); }	
}

class InvalidDateException extends Exception {
	InvalidDateException () { super(); }
	InvalidDateException (String s) { super(s); }	
}
