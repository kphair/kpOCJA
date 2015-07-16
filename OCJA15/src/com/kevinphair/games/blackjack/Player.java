package com.kevinphair.games.blackjack;

import java.util.Arrays;

/**
 * Class to hold player information
 * 
 * @author Kevin Phair
 * @date 16 Jul 2015
 * @version 1.0
 */
public class Player {
	
	private String name;
	private Card[] hand;
	private int gamesWon;
	private int gamesLost;
	private int gamesPlayed;
	
	/**
	 * Constructor for a new, named player
	 * @param name as String
	 */
	public Player (String name) {
		this.name = name;
		hand = new Card[0];
		this.gamesWon = 0;
		this.gamesLost = 0;
		this.gamesPlayed = 0;
		
	}
	
	/**
	 * Add a new card to the player's hand
	 * 
	 * Creates a copy of the provided array with one extra element and places
	 * the provided object reference of the new card into the extra element
	 * 
	 * @param Card object taken from the deck
	 */
	public void addCard (Card c) {
		hand = Arrays.copyOf(hand, hand.length + 1);
		hand[hand.length - 1] = c;
	}
	
	/**
	 * Show the player's hand
	 */
	public void showHand () {
		if (hand.length > 0) {
			for (Card c : hand) {
				System.out.println("card " + c.getRankName() + " of " + c.getSuitName());
			}
		}
	}

	/**
	 * Show the last card put in the player's hand
	 */
	public void showLastCard () {
		if (hand.length > 0) {
			System.out.println("Last card drawn was " + hand[hand.length - 1].getName());
		}
	}
	
	/**
	 * return the player's name
	 * @return player's name as String
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the player's name
	 * @param player's name as String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the player's current hand
	 * @return Card array containing all the cards in hand
	 */
	public Card[] getHand() {
		return hand;
	}
	/**
	 * set the player's current hand
	 * @param Card array containing the hand to give the player
	 */
	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	/**
	 * Get the number of games the player has won
	 * @return number of games won as an int
	 */
	public int getGamesWon() {
		return gamesWon;
	}
	/**
	 * Set the number of games the player has won
	 * @param number of games won as an int
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}
	/**
	 * Increment the games won counter by one
	 */
	public void addGameWon() {
		gamesWon++;
	}
	/**
	 * Get the number of games the player lost
	 * @return games lost as an int
	 */
	public int getGamesLost() {
		return gamesLost;
	}
	/**
	 * Set the number of games the player has lost
	 * @param games lost as an int
	 */
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}
	/**
	 * Increment the games lost counter by one
	 */
	public void addGameLost() {
		gamesLost++;
	}
	/**
	 * Get number of games the player has played
	 * @return games played as an int
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	/**
	 * Set the number of games the player has played
	 * @param games played as an int
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	/**
	 * Increment the games played counter by one
	 */
	public void addGamePlayed() {
		gamesPlayed++;
	}

	
	
	
}

