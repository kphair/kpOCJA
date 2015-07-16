/**
 * Created 16 Jul 2015
 * @author Kevin Phair
 * 
 */
package com.teamorange.blackjack;

/**
 * 
 * @author Mubasher Mohammed, Kevin Phair, Jenn Quinn, Seamus O'Toole
 * @version 1.0
 */
public class Card {

	enum Suit { DIAMONDS, HEARTS, CLUBS, SPADES }
	enum Owner { DECK, DEALER, PLAYER}
	int faceValue;		// 1 -13
	Suit suit;
	Owner owner;

	public Card(Suit suit, int value) {
		this.faceValue= value;
		this.suit = suit;
		this.owner = Owner.DECK;		
	}

	public int getCardScore(Owner owner) {
		
		if (this.faceValue > 10) {
			return 10;
		} else if (this.faceValue == 1){
			return 11;
		} else {
			return this.faceValue;
		}
	}
	
	public void setOwner(Owner owner) {
		if (this.owner == Owner.DECK) this.owner = owner;
	}

	public Owner getOwner() {
		return this.owner;
	}
}
