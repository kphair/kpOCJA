package com.kevinphair.ocja.exercises;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {

		Random rand = new Random();
		Scanner scan = new Scanner(System.in);



		int randNumber = 0;
		int userGuess = 0;
		int guessCount = 0;
		String userInput = null;
		int[] haveGuess = new int[20];
		

		mainLoop:
			for(;;){
				randNumber = rand.nextInt(19) + 1;
				System.out.println(randNumber);
				// Clear the array which keeps track of the number of times a number was guessed
				for(int i = 0; i < haveGuess.length; ++i) {
					haveGuess[i] = 0;
				}
				// Start of the main program loop
				for(;;){
					//		System.out.println("Hello World");
					// Get a number from the user
					System.out.println("Please enter a number between 1 and 20 inclusive");
					while (! scan.hasNextInt()) {
						scan.next();
						System.out.println("You entered something other than a number. Please try again.");
					}
					userGuess = scan.nextInt();
					
					// Check that the number is within the permissible range
					if(userGuess < 1 || userGuess > 20){
						System.out.println("Your guess is out of range");	
					}else{
						/*
						 * Pseudocode for client addition to spec
						 * 
						 * Declare an array for keeping track of how many times a specific number has been guessed
						 * 
						 * IF the number already guessed
						 *     Increment element in guess count array for this number
						 *     Notify the user the number already guessed
						 *     Go to next iteration of loop
						 * END IF
						 */
						if(haveGuess [userGuess-1] != 0){
							System.out.println("you already guessed that");
							continue;
						}
						haveGuess [userGuess-1]++;
						
						// Display the current guess and increment the number of guesses 
						System.out.println("Your guess is " + userGuess);
						guessCount++;

						// Check to see if the user's matches the random number the computer picked
						if(userGuess == randNumber){
							System.out.println("Congratulations! Your number of guesses was " + guessCount
									+ ". The right answer was " + randNumber);
							break;
							
						}else{
							System.out.println("Please guess again");
						}
					}

				}// Inner Loop

				//			System.out.println(userInput);

				// Loop to ask if they want to play again
				for(;;){
					System.out.println("Would you like to play again? Y/N");
					userInput = scan.next();
					userInput = userInput.toUpperCase();
					if(userInput.equals ("Y")){
						break;
					}else if(userInput.equals("N")){
						System.out.println("Goodbye");
						break mainLoop;
					}else{
						System.out.println("Invalid choice");
					}
				}
			}// Top Loop - end of mainLoop
	}
}
