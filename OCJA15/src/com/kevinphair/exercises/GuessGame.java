package com.kevinphair.exercises;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	/**
	 * Code challenge for July 6th - Guessing Game
	 * Team: Kevin, Jenn, Sam, Mubasher
	 *
	 * CLIENT SPECIFICATION
	 *  
	 * - Write a game which will generate a number in the range of 1 to 20 inclusive.
	 * - Ask the user to guess this number until they get it correct.
	 * - ADD: Show them which numbers they've already guessed (duplicate guesses don't count as turns).
	 * - ADD: Show them which numbers are left to be guessed.
	 * - When they have guessed it, print a congratulations message and ask if they want to play again (Y/N).
	 * - Keep playing this game until they say "N".
	 * 
	 * Pseudo-code for application
	 * 
	 *  DECLARE an integer for storing the random number
	 *  DECLARE an integer for storing the user's guess
	 * 	DECLARE an array for keeping track of how many times that guess has been tried
	 * 	DECLARE an integer for storing how many guesses have been made
	 * 
	 * 	WHILE application running
	 * 		GENERATE a random number for a game 
	 * 		WHILE game running
	 * 			SHOW the numbers that have already been guessed (if any)
	 * 			SHOW the numbers that can be guessed
	 * 			ASK for a number from the user
	 * 			IF the user number is valid
	 * 				IF the user number does NOT match the random number
	 * 					SHOW a message to say the guess was incorrect
	 * 					IF the guessed number's matching element in the guess count array is > 0
	 * 						Notify the user the number already guessed
	 * 					END IF
	 * 					Increment element in guess count array for this number
	 * 				ELSE
	 * 					SHOW a congratulations message
	 * 					SHOW how many guesses they made
	 * 					ASK if they want to play again. Y or N response required
	 * 					IF response is N
	 * 						EXIT application running loop
	 * 					ELSE IF response is Y
	 * 						EXIT game running loop
	 * 					END IF			
	 * 				END IF
	 * 			END IF
	 * 		END WHILE
	 *	END WHILE 
	 */

	public static void main(String[] args) {

		boolean debug = true;
		int randNumber = 0;
		int userGuess = 0;
		int guessCount;
		int[] haveGuessed = new int[20];
		final int MAX_GUESSES = 10;
		String userInput = "";
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		do {
			randNumber = rand.nextInt(19) + 1;
			if (debug) System.out.println(randNumber);
			guessCount = 0;

			// Clear the array which keeps track of the number of times a number was guessed
			for (int i = 0; i < haveGuessed.length; ++i) {
				haveGuessed[i] = 0;
			}

			// Start of the main program loop
			do {
				// Get a number from the user
				System.out.println("Please enter a number between 1 and 20 inclusive");
				if (MAX_GUESSES > 0) {
					if (guessCount == 0) {
						System.out.println("You have " + (MAX_GUESSES - guessCount) + " chancees to get it right...");
					} else if (MAX_GUESSES - guessCount > 1) {
						System.out.println("You have " + (MAX_GUESSES - guessCount) + " chances left...");
					} else {
						System.out.println("You only have ONE chance left!");
					}
				}

				// Show the numbers that haven't been guessed yet
				System.out.print("  Numbers you can pick from are: ");
				for (int i = 0; i < haveGuessed.length; ++i) {
					if (haveGuessed[i] == 0) {
						System.out.print(i + 1 + "  ");
					}
				}
				System.out.println();

				// Show the numbers that have already been guessed
				if (guessCount > 0) {
					System.out.print("  So far you have already guessed: ");
					for (int i = 0; i < haveGuessed.length; ++i) {
						if (haveGuessed[i] > 0) {
							System.out.print(i + 1 + "  ");
						}
					}
					System.out.println();
				}

				// Wait for an integer to be entered
				while (! scan.hasNextInt()) {
					scan.next();				// Was not an int, skip over it
					System.out.println("You entered something other than a number. Please try again.");
				}
				userGuess = scan.nextInt();

				// Check that the number is within the permissible range
				if (userGuess < 1 || userGuess > 20) {
					System.out.println("Your guess is out of range");	
				} else {
					if (haveGuessed[userGuess-1] != 0) {
						System.out.println(userGuess + " has already been guessed.");
						continue;			// Go back to the start of the for loop
					}
					haveGuessed[userGuess-1]++;		// Increment the number of times that number was guessed
					guessCount++;			// increment the number of guesses

					// Check to see if the user's matches the random number the computer picked
					if (userGuess == randNumber) {
						System.out.println("Congratulations - The correct number was " + randNumber + ".");
						System.out.println("It took you " + guessCount + " guess" + (guessCount != 1 ? "es." : "."));
						break;			// Break out of the guessing loop
					} else {
						if ((MAX_GUESSES > 0) && (guessCount >= MAX_GUESSES)) {
							System.out.println("Sorry, you ran out of goes. The number I had was " + randNumber + ".");
							System.out.println();
							break;
						} else {
							System.out.println("You guessed " + userGuess + ", guess again.");
						}
					}

				} // end of guess checking
				
			} while (userGuess != randNumber); 		// End of inner Loop

			// This second loop is asking if the user wants to play again
			System.out.println("Would you like to play again? Y/N");
			while (true) {
				userInput = scan.next().toUpperCase();
				if (debug) System.out.println("You entered " + userInput);
				if (! "YN".contains(userInput)) {
					System.out.println("Invalid choice - Expecting Y or N...");
				} else {
					break;
				}
			}
		} while (! userInput.equals("N"));			// Top Loop - end of mainLoop

		scan.close();
		
		System.out.println("Thank you for playing. Goodbye!");
	}
}
