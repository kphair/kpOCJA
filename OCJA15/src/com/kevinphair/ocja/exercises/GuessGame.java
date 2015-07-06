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

				for(;;){
					//		System.out.println("Hello World");
					System.out.println("Please enter a number between 1 and 20 inclusive");
					userGuess = scan.nextInt();
					if(userGuess < 1 || userGuess > 20){
						System.out.println("This number is out of range");	
					}else{
						/*
						 * IF the number already guessed
						 *     increment element in guess count array for this number
						 *     notify the user the number already guessed
						 *     Go to next iteration of loop
						 * END IF
						 */
						if(haveGuess [userGuess-1] != 0){
							System.out.println("you already guessed that");
							continue;
						}
						haveGuess [userGuess-1]++;
						
						guessCount++;
						System.out.println("Your guess is " + userGuess);

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
