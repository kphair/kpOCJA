/**
 * Card
 * @author Kevin Phair
 * @date 16 Jul 2015
 * @version 1.0.0
 */
package com.kevinphair.games.blackjack;

/**
 * @author Kevin Phair
 * @date 16 Jul 2015
 */
public class Card {

	// Please make sure the suitnames, symbols and enum are all in the same order!
	String[] suitNames = new String[] { "Hearts", "Diamonds", "Clubs", "Spades" };
	String suitSymbols = "\u2665\u2666\u2663\u2660";
	enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
	Suit suit;

	String[] rankNames = new String[] {
			"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
			"Jack", "Queen", "King"
	};
	String shortRankNames = "A234567879JQK";
	int rank;
	
	/**
	 * Constructor for a new card
	 * @param suit as enum Suit
	 * @param rank as int 1 to 13
	 */
	public Card (Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getRankName () {
		return rankNames[rank];
	}
	
	public char getShortRankName () {
		return shortRankNames.charAt(rank - 1);
	}
	
	public String getSuitName () {
		return suitNames[suit.ordinal()];
	}
	
	public char getSuitSymbol () {
		return suitSymbols.charAt(suit.ordinal());
	}
	
	public String getName () {
		return this.getRankName() + " of " + this.getSuitName(); 
	}
	
}
