package com.skilldistillery.cards;

import java.util.*;

public class Deck {
	private List<Card> deck = new ArrayList<Card>(52);

	public List<Card> createDeck() {

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {

				deck.add(new Card(r, s));

			}
		}
//		shuffleCards(deck);
		return deck;

	}

	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;

	}

	public Card dealCards() {
		return deck.remove(0);

	}

	public void shuffleCards() {
		Collections.shuffle(deck);
	}
}
