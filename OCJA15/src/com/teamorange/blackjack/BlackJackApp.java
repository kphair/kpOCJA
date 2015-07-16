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
	}//end main
	
	public boolean playOneHand(){
		initaliseDeck();
		shuffleDeck();
		int playerScore = 0;
		int dealerScore = 0;
		
		this.drawCard(Card.Owner.PLAYER);
		for(;;){
			this.drawCard(Card.Owner.PLAYER);
			playerScore = this.getScore(Card.Owner.PLAYER);
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
			} else if (dealerScore > playerScore){
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
				if (this.playOneHand()){
					player1Wins++;
				} else {
				player2Wins++;
				}
			} else {
				if (this.playOneHand()){
					player2Wins++;
				} else {
					player1Wins++;
				}
			}
			System.out.printf("Current scores \n player1: %d \n player2: %d", player1Wins, player2Wins);
			System.out.println("press enter to show next hand");
			scan.next();
		}
	}
	
		
	public void initaliseDeck() {
	
		for (int i = 0; i < 13; ++i) {
			
			deck[i] = new Card(Card.Suit.HEARTS, i);
			deck[i + 13] = new Card(Card.Suit.DIAMONDS, i);
			deck[i + 26] = new Card(Card.Suit.SPADES, i);
			deck[i + 39] = new Card(Card.Suit.CLUBS, i);
				
		}
	}
	
	public void shuffleDeck() {
		Card tempCard = null;
		Card firstCard = null;
		Card secondCard = null;
		
		for (int i = 0; i < 100; ++i) {
			firstCard = deck[new Random().nextInt(52)];
			secondCard = deck[new Random().nextInt(52)];

			tempCard = firstCard;
			firstCard = secondCard;
			secondCard = tempCard;  
		}
	}
	
	public void drawCard(Card.Owner owner) {
		deck[currentCard++].setOwner(owner);
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
