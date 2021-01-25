/*
* Dealer.java
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
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or has 5 cards.
 *
 */
public class Dealer {
	/**
	 * The dealers hand
	 */
	Hand hand;
	
	/**
	 * Construct a new dealer with an empty hand
	 */
	public Dealer() {
		hand = new Hand();
	}
	
	/**
	 * Dealer draws a card if his hand is worth less than 17 points and has less than 5 cards in in his hand.
	 * 
	 * @param deck
	 * @return
	 */
	public Card playTurn(Deck deck) {
		Card drawnCard = null;
		int valOfHand = BlackJack.getValueOfHand(this.getHand());
		int sizeOfHand = hand.size();
		//if hand is less than 17 and has less than 5 cards in hand
		if (valOfHand < 17 && sizeOfHand < 5) 
		{
			drawnCard  = deck.draw(); //draws a card from the deck
			hand.addCard(drawnCard); //drawn card gets added to hand
			return drawnCard;
		}
		else //if dealer has too many cards or too many points
		{
		return null;
		}
	}
	
	/**
	 * A method to check if the dealer has busted
	 * @return boolean true if the dealer has busted
	 */
	public boolean busted() {
		if (BlackJack.getValueOfHand(hand) > 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * A method to check if the dealer will draw a card.
	 * @return
	 */
	public boolean isDone() {
		if (BlackJack.getValueOfHand(hand) < 17 &&  hand.size() < 5)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Returns the dealers cards to the deck
	 * @param d Deck to return the cards to
	 */
	public void returnCardstoDeck(Deck d) {
		Card[] emptying = hand.emptyHand();
		for (int i = 0; i < emptying.length; i++)
		{
			d.addToBottom(emptying[i]);
		}
	}
	
	/**
	 * @return Hand the dealer's hand
	 */
	public Hand getHand() {
		return hand;
	}
}
