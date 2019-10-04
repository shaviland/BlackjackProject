package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

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

	public boolean checkBlackJack() {
		return playerHand.isBlackJack();
	}

	public boolean checkBust() {
		return playerHand.isBust();
	}
}
