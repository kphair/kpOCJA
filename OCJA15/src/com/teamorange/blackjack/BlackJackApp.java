/**
 * Created 16 Jul 2015
 * @author Kevin Phair
 * 
 */
package com.teamorange.blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Mubasher Mohammed, Kevin Phair, Jenn Quinn, Seamus O'Toole
 * @version 1.0
 *
 */
public class BlackJackApp {

	static int currentCard = 0;

	Card[] deck = new Card[52];
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		BlackJackApp ba = new BlackJackApp();
		ba.runApp();
	} //end main
	
	public boolean playOneHand(){
		initaliseDeck();
		shuffleDeck();
		int playerScore = 0;
		int dealerScore = 0;
		
		this.drawCard(Card.Owner.PLAYER);
		for(;;){
			this.drawCard(Card.Owner.PLAYER);
			playerScore = this.getScore(Card.Owner.PLAYER);
			System.out.println(playerScore);
			if (playerScore > 21){
				return true;
			}else if (playerScore == 21){
				return false;
			}else if (playerScore > 16){
				break;
			}
		}
		this.drawCard(Card.Owner.DEALER);
		for(;;){
			this.drawCard(Card.Owner.DEALER);
			dealerScore = this.getScore(Card.Owner.DEALER);
			if (dealerScore > 21){
				return false;
			} else if (dealerScore >= playerScore){
				return true;
			}
		}

	}
	
	private void runApp(){
		int numGames = 11;
		int player1Wins = 0; 
		int player2Wins = 0; 
		

		for (int i = 0; i < numGames; ++i){
			if (i%2 == 0){
				System.out.println("\nStart of new game. Player 1 is the dealer.");
				if (this.playOneHand()){
					player1Wins++;
				} else {
				player2Wins++;
				}
			} else {
				System.out.println("\nStart of new game. Player 2 is the dealer.");
				if (this.playOneHand()){
					player2Wins++;
				} else {
					player1Wins++;
				}
			}
			System.out.printf("Current scores \n player1: %d \n player2: %d\n", player1Wins, player2Wins);
			if (i == numGames - 1) {
				if (player1Wins > player2Wins) {
					System.out.println("Player 1 was the winner out of " + numGames + " games.");
				} else {
					System.out.println("Player 2 was the winner out of " + numGames + " games.");
				}
				System.out.println("That is the end of the tournament.");
				break;
			}
			System.out.println("Enter 'n' to show next hand");
			scan.next();
		}
	}
	
		
	public void initaliseDeck() {
	
		currentCard = 0;

		for (int i = 0; i < 13; ++i) {
			
			deck[i] = new Card(Card.Suit.HEARTS, i);
			deck[i + 13] = new Card(Card.Suit.DIAMONDS, i);
			deck[i + 26] = new Card(Card.Suit.SPADES, i);
			deck[i + 39] = new Card(Card.Suit.CLUBS, i);
				
		}
	}
	
	public void shuffleDeck() {
		Card firstCard = null;
		Card secondCard = null;
		int pick1;
		int pick2;
		
		for (int i = 0; i < 100; ++i) {
			pick1 = new Random().nextInt(52);
			pick2 = new Random().nextInt(52);
			firstCard = deck[pick1];
			secondCard = deck[pick2];

			deck[pick2] = firstCard;
			deck[pick1] = secondCard;

		}
	}
	
	public void drawCard(Card.Owner owner) {
		deck[currentCard].setOwner(owner);
		System.out.print(owner.name() + " draws ");
		deck[currentCard].showCard();
		currentCard++;
		
	}
	
	public int getScore(Card.Owner owner) {
		int score = 0;
		for (int i = 0; i < deck.length; ++i) {
			if (deck[i].getOwner() == owner) {
				score += deck[i].getCardScore(owner);
			}
		}
		return score;
	}
	
	
}
