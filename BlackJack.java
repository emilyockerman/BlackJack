/*
* BlackJack.java
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
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		deck = new Deck();
		dealer = new Dealer();
		player = new Player();
		Hand dHand = dealer.getHand();
		Hand pHand = player.getHand();
		deck.shuffle();
		Card c1 = deck.draw();
		Card c2 = deck.draw();
		dHand.addCard(c1);
		dHand.addCard(c2);
		Card c3 = deck.draw();
		Card c4 = deck.draw();
		pHand.addCard(c3);
		pHand.addCard(c4);
	}
	
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		dealer.returnCardstoDeck(deck);
		player.returnCardstoDeck(deck);
		deck.shuffle();
		Card c1 = deck.draw();
		Card c2 = deck.draw();
		dealer.getHand().addCard(c1);
		dealer.getHand().addCard(c2);
		Card c3 = deck.draw();
		Card c4 = deck.draw();
		player.getHand().addCard(c3);
		player.getHand().addCard(c4);
	}
	
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		int value = 0;
		
		switch(c.getType()) {
		
		case JACK:
			value = 10;
			break;
		case QUEEN:
			value = 10;
			break;
		case KING:
			value = 10;
			break;
		case ACE:
			value = 1;
			break;
		case TWO:
			value = 2;
			break;
		case THREE:
			value = 3;
			break;
		case FOUR:
			value = 4;
			break;
		case FIVE:
			value = 5;
			break;
		case SIX:
			value = 6;
			break;
		case SEVEN:
			value = 7;
			break;
		case EIGHT:
			value = 8;
			break;
		case NINE:
			value = 9;
			break;
		case TEN:
			value = 10;
			break;
		}
		return value;
	}
	
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		int value = 0;
		Card[] hand = h.getCards();
		for (int i = 0; i < h.getCards().length; i ++) {
			int cardVal = BlackJack.getValueOfCard(hand[i]);
			value += cardVal;
		}
		if (value < 21 && (value + 10 <= 21)) {
			for(int i = 0; i < h.getCards().length; i++) {
				if (hand[i].getType() == Card.Type.ACE) {
					value += 10;
				}
			}
		}
		return value;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
