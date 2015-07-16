/**
 * BlackjackApp
 * @author Kevin Phair
 * @date 16 Jul 2015
 * @version 1.0.0
 */
package com.kevinphair.games.blackjack;

/**
 * @author Kevin Phair
 * @date 16 Jul 2015
 */
public class BlackjackApp {

	public static void main(String[] args) {

		Deck deck = new Deck();
		
		Player player = new Player("Fred");
		Player dealer = new Player("Bob");
		
		System.out.println(dealer.getName() + " has won " + dealer.getGamesWon() + " games.");
		System.out.println(player.getName() + " has won " + player.getGamesWon() + ".");
		System.out.println(dealer.getName() + " is dealing. " + player.getName() + " to start...");

		deck.shuffleDeck();
		
		deck.showAbbreviatedDeck();
		player.addCard(deck.takeCard());
		player.showLastCard();
		player.showHand();
		deck.showAbbreviatedDeck();
		player.addCard(deck.takeCard());
		player.showLastCard();
		player.showHand();
		
	}

}
