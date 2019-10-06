package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Participant {
	
	private Deck gameDeck = new Deck();
	
	private BlackJackHand dealerHand = new BlackJackHand();

	public void getDeck() {
		gameDeck.createDeck();
	}

	public void shuffle() {
		gameDeck.shuffleCards();
	}

	public Card getCard() {

		return gameDeck.dealCards();

	}
	

	
	public BlackJackHand gameHand(Card card) {
		
		dealerHand.addCard(card);
		
		return dealerHand;
	}
	
	@Override
	public int checkHand() {
		
	return dealerHand.getHandValue();

	}
	public void printHand() {
		System.out.println("Dealers hand: ");
		dealerHand.printCards();
	}
	public boolean checkBlackJack() {
		return dealerHand.isBlackJack();
	}

	public boolean checkBust() {
		return dealerHand.isBust();
	}
//	public void newhand() {
//		dealerHand = null;
//	}
}
