/*
* Hand.java
* Author: Emily Ockerman
* Submission Date: December 3, 2018
*
* Purpose: One of the classes used to play a game of BlackJack.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science.
*/

/**
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		//create new array with room for the card = current length of card array + 1
		//copy over all elements of old array and then add c to the end
		Card[] temp = new Card[cards.length + 1];
		for (int i = 0; i < cards.length; i++) {
			temp[i] = cards[i];
		}
		temp[temp.length-1] = c;
		cards = temp;
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		return this.getCards().length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		// Ensure you return reference to the copy of the cards array
		// and not a reference actual cards array!
		Card[] temp = new Card[cards.length];
		for (int i = 0; i < cards.length; i ++) {
			temp[i] = cards[i];
		}
		cards = temp;
		return cards;
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {
		Card[] temp = new Card[cards.length];
		Card[] empty = new Card[0];
		for (int i = 0; i < cards.length; i++) {
			temp[i] = cards[i];
		}
		cards = empty;
		return temp;
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		String cardz = "";
		if (this.getCards().length == 0){
			return "Empty Hand";
		}
		else
		{
			for(int i = 0; i < this.getCards().length; i++) {
				String one = "";
				one = i + ". " + cards.toString() + "\n";
				cardz += one;
			}
		}
		return cardz;
	}
}
