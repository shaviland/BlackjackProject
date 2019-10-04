package com.skilldistillery.blackjack;

import java.util.List;

import com.skilldistillery.cards.Card;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlackJackHand(List<Card> cards) {
		super(cards);
		
		// TODO Auto-generated constructor stub
	}

	public boolean isBlackJack() {

		if (getHandValue() == 21) {
			return true;

		}

		return false;

	}

	public boolean isBust() {

		if (getHandValue() > 21) {

			return true;
		}

		return false;

	}

	@Override
	public int getHandValue() {
		int value = 0;

		for (Card card : cards) {
			if (card != null) {
				System.out.println(card);
				value += card.getValue();
			}

		}

		return value;

	}

}
