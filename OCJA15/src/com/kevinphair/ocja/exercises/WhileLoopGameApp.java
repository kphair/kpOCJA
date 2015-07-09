package com.kevinphair.ocja.exercises;

import java.util.Random;
import java.util.Scanner;

public class WhileLoopGameApp {

	static String[] attackTypes = { "viciously attacked", "crushed", "mauled", "eaten" };
	static String[] monsterTypes = { "large snake", 
									"wild boar", 
									"hippopotamus", 
									"sabre-toothed tiger", 
									"carnivorous plant",
									"And & Dec",
	};

	
	public static void main(String[] args) {

		int numGames = 0;
		int currentGame = 0;
		final int MAX_GAMES = 10;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many lives do you want in this game? (valid options are from 1 to 10)");
		
		do {
			while (! scan.hasNextInt()) {
				scan.next();
			}
			numGames = scan.nextInt();
			if ((numGames < 1) || (numGames > MAX_GAMES)) {
				System.out.println(numGames + " is an invalid number. Please try again...");
			} else {
				break;
			}
		} while (true);

		currentGame = 1;
		System.out.println("Welcome to The Jungle!");
		while (numGames > 0) {
			System.out.println("This is turn number " + currentGame);
			switch (new Random().nextInt(3)) {
				case 0:
					System.out.print("  You sense something moving just outside your vision");
					break;

				case 1:
					System.out.print("  You hear a rustling noise behind you");
					break;
					
				case 2:
					System.out.print("  You feel something brush against your ankle");
					break;
			}
			try {
				for (int i = 0; i < 3; ++i) {
					System.out.print(".");
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				
			} finally {
				System.out.println();
			}
			System.out.print("  * You were " + attackTypes[new Random().nextInt(attackTypes.length)]);
			System.out.println(" by a " + monsterTypes[new Random().nextInt(5)] + "!!!");
			System.out.println("  You are now dead.");
			System.out.println();
			numGames--;
			currentGame++;
		}
		System.out.println("You have been evicted from The Jungle. GAME OVER");
		
		scan.close();
	}

}
