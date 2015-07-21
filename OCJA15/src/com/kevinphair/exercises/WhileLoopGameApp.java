package com.kevinphair.exercises;

import java.util.Random;
import java.util.Scanner;

public class WhileLoopGameApp {

	static String[] senseTypes = {	"sense something moving just outside your vision",
								   	"hear a rustling noise behind you",
									"feel something brush against your ankle",
	};
	static String[] attackTypes = {	"viciously attacked",
									"crushed",
									"mauled",
									"eaten",
									"disemboweled",
	};
	static String[] monsterTypes = { "large snake", 
									"wild boar", 
									"hippopotamus", 
									"rabid Mario", 
									"Spice-crazed sandworm", 
									"sabre-toothed tiger", 
									"carnivorous plant",
									"And & Dec",
									"indescribable, pulpous mass",
	};
	
	public static void main(String[] args) {

		int numGames = 0;
		int currentGame = 0;
		final int MAX_GAMES = 10;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to The Jungle!");
		System.out.println("How many lives do you want? (valid options are from 1 to 10)");
		
		do {
			while (! scan.hasNextInt()) {
				scan.next();
			}
			numGames = scan.nextInt();
			if ((numGames < 1) || (numGames > MAX_GAMES)) {
				System.out.println(numGames + " is an invalid number. Please try again...");
				numGames = 0;
			}
		} while (numGames == 0);

		System.out.println("Thank you. You will have " + numGames + " chances to survive among the beasts.");
		System.out.println();
		
		currentGame = 1;
		while (numGames > 0) {
			System.out.print("Turn number " + currentGame + " - ");
			System.out.print("You " + senseTypes[new Random().nextInt(senseTypes.length)]);
			try {
				for (int i = 0; i < 3; ++i) {
					System.out.print(" .");
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				
			} finally {
				System.out.println();
			}
			System.out.print("  * You were " + attackTypes[new Random().nextInt(attackTypes.length)]);
			System.out.print(" by a " + monsterTypes[new Random().nextInt(monsterTypes.length)] + "!");
			System.out.println("  You are now dead.");
			System.out.println();
			numGames--;
			currentGame++;
		}
		System.out.println("GAME OVER");
		
		scan.close();
	}

}
