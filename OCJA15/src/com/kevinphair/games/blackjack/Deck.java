/**
 * Deck
 * @author Kevin Phair
 * @date 16 Jul 2015
 * @version 1.0.0
 */
package com.kevinphair.games.blackjack;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Kevin Phair
 * @date 16 Jul 2015
 */
public class Deck {

	Card[] deck = new Card[52];
	
	/**
	 * Constructor for a new, ordered deck of cards
	 */
	public Deck() {
		
		deck = new Card[52];
		int cardNum = 0;
		
		for (Card.Suit c : Card.Suit.values()) {
			for (int i = 1; i <= 13; ++i) {
				deck[cardNum++] = new Card(c, i); 
			}
		}
	}
	
	/**
	 * Remove a card object from the deck and return it to the caller
	 */
	public Card takeCard () {
		Card c = deck[0];
		
		// Take the first element out of the deck array and reduce its size
		deck = Arrays.copyOfRange(deck, 1, deck.length - 1);
		
		return c;
	}
	
	public void shuffleDeck () {
		Card card1;
		Card card2;

		for (int i = 0; i < 100; ++i) {
			// Pick 2 cards from the deck, any cards
			int pick1 = new Random().nextInt(deck.length);
			int pick2 = new Random().nextInt(deck.length);

			// Swap them around
			card1 = deck[pick1];
			card2 = deck[pick2];
			deck[pick1] = card2;
			deck[pick2] = card1;
		}
		
	}
	
	/**
	 * Show the cards held in the deck;
	 */
	public void showDeck() {
		int numShown = 0;
		
		for (Card c : deck) {
			System.out.println(c.getRankName() + " of " + c.getSuitName());
			numShown++;
			if (numShown == 13) {
				System.out.println();
				numShown = 0;
			}
		}
	}

	/**
	 * Show the cards held in the deck in abbreviated form;
	 */
	public void showAbbreviatedDeck() {
		int numShown = 0;
		
		for (Card c : deck) {
			System.out.print(c.getShortRankName() + "" + c.getSuitName().charAt(0));
			numShown++;
			if (numShown == 13) {
				System.out.println();
				numShown = 0;
			} else {
				System.out.print(", ");
			}
		}
	}

	/**
	 * Show the cards held in the deck in symbolic form;
	 */
	public void showSymbolicDeck() {
		int numShown = 0;
		
		for (Card c : deck) {
			System.out.print(c.getShortRankName() + "" + c.getSuitSymbol());
			numShown++;
			if (numShown == 13) {
				System.out.println();
				numShown = 0;
			} else {
				System.out.print(", ");
			}
		}
	}
	
}
