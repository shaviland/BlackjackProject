package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;


public abstract class Hand {

	protected List<Card> cards = new ArrayList<>();

	public Hand() {
		super();
	}

	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public void addCard(Card cardsDealt) {
		cards.add(cardsDealt);
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return String.format("Hand [cards=%s]", cards);
	}
	
	
}
