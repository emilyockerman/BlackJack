/*
* Deck.java
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

import java.util.Random;

/**
 * Class representing a standard 52 card deck. Allows users to shuffle, draw,
 * and add cards to the bottom for the purpose of playing various card games.
 */
public class Deck {
	
	/**
	 * Cards in the deck
	 */
	private Card [] cards;
	
	/**
	 * The number of cards in the physical deck on the table.
	 */
	private int numCardsInDeck;
	
	/**
	 * Create a standard 52 card deck w/ one of each type (Ace, King, Queen...) for each Suit (Hearts, Spades ..)
	 */
	public Deck() {
		
		Card.Suit [] suits = Card.Suit.values(); //creates an array of all of the Suits
		Card.Type [] types = Card.Type.values(); //creates an array of all of the Types
		cards = new Card[suits.length*types.length]; //sets the size of cards to 52 (types & suits)
		numCardsInDeck = 0;
		
		for(int i =0; i<suits.length; i++)
		{
			for(int j = 0; j<types.length; j++)
			{
				//Assigns 52 unique cards to the cards deck
				cards[numCardsInDeck] = new Card(types[j], suits[i]); 
				numCardsInDeck++; //increments the number of cards in the deck
			}
		}	
	}
	/**
	 * Draws card from the top
	 * @return the top card
	 */
	public Card draw() {
		if (numCardsInDeck == 0)
		{
			return null;
		}
		else
		{
			numCardsInDeck -= 1;
			return cards[numCardsInDeck];
		}
	}

	/**
	 * Swaps card at a with card at b
	 * @param a card to be swapped with b
	 * @param b card to be swapped with a
	 */
	private void swap(int a, int b) {
		Card temp = this.cards[a];
		this.cards[a] = this.cards[b];
		this.cards[b] = temp;
	}
	
	/**
	 * Shifts all the cards in the deck right by one place
	 */
	private void shiftRightOne() {
		if(numCardsInDeck == 52) {
			System.out.println("error. deck full");
		}
		else {
			Card[] t = new Card[cards.length+1];
			for(int i = 0; i < cards.length; i++) {
				t[i+1] = cards[i];
			}
			cards = t;
		}
	}	
	
	/**
	 * Add c to the bottom of the deck
	 * Print "Deck Full" when count equals the size of the deck
	 * @param c card to add
	 */	
	public void addToBottom(Card c) {
		if(numCardsInDeck == 52) {
			System.out.println("Deck full");
		}
		else {
			this.shiftRightOne();
			cards[0] = c;
			numCardsInDeck += 1;
		}
	}

	/**
	 * Shuffles the deck by swapping the cards 100 times
	 */
	public void shuffle() {
		Random r = new Random();
		int r1 = r.nextInt(numCardsInDeck);
		int r2 = r.nextInt(numCardsInDeck);
		
		for (int i = 0; i < 100; i++) {
			this.swap(r1, r2);
		}
		
	}
	/**
	 * Shuffles the deck by swapping cards n times
	 * @param n number of swaps
	 */
	public void shuffle(int n) {
		Random r = new Random();
		int r1 = r.nextInt(numCardsInDeck);
		int r2 = r.nextInt(numCardsInDeck);
		
		for (int i = 0; i < n; i++) {
			this.swap(r1, r2);
		}
	}

}
