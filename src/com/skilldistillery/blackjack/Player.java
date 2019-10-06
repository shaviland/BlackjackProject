package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class Player extends Participant {

	private BlackJackHand playerHand = new BlackJackHand();

	
	public BlackJackHand gameHand(Card card) {

		playerHand.addCard(card);

		return playerHand;
	}

	@Override
	public int checkHand() {
		return playerHand.getHandValue();

	}

	public void printHand() {
		System.out.println("players hand: ");
		playerHand.printCards();
	}

	public boolean checkBlackJack() {
		return playerHand.isBlackJack();
	}

	public boolean checkBust() {
		return playerHand.isBust();
	}
//	public void newHand() {
//		playerHand = null;
//	}
}
