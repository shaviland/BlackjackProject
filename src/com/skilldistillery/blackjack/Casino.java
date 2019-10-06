package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;

public class Casino {
	Dealer dealer = new Dealer();
	Player player = new Player();
	static Scanner kb = new Scanner(System.in);
	boolean quit = false;

	public static void main(String[] args) {
		Casino cas = new Casino();

		cas.play();

	}

	private void play() {
		dealer.getDeck();
		System.out.println("Dealer is shuffling the deck");
		dealer.shuffle();
		do {
			Card playerCard1 = dealer.getCard();
			System.out.println("Player is dealt " + playerCard1);
			player.gameHand(playerCard1);

			Card dealerCard1 = dealer.getCard();
			System.out.println("Dealer shows " + dealerCard1);
			dealer.gameHand(dealerCard1);

			Card playerCard2 = dealer.getCard();
			System.out.println("Second player card is " + playerCard2);
			player.gameHand(playerCard2);

			Card dealerCard2 = dealer.getCard();
			dealer.gameHand(dealerCard2);

			if (dealer.checkBlackJack()) {
				System.out.println("Dealer: BlackJack");
			}
			boolean playerBust = playerTurn(player);
			if (!playerBust) {
				dealerTurn(dealer);
			}
			endGame(player, dealer, playerBust);
		} while (!quit);

	}

	private boolean playerTurn(Player player) {
		do {
			System.out.println("Player hand is ");
			player.printHand();
			System.out.println(player.checkHand() + " total.");
			System.out.println("Hit or Stay?");
			String playerChoice = kb.nextLine();

			if (playerChoice.equalsIgnoreCase("hit")) {
				Card playerCard = dealer.getCard();
				player.gameHand(playerCard);
				if (player.checkBust()) {
					System.out.println("Player is dealt " + playerCard);
					System.out.println(player.checkHand());
					System.out.println("Player busts.");
					return true;

				}
			} else if (playerChoice.equalsIgnoreCase("stay")) {
				break;
			} else {
				System.err.println("That is not a valid input.");
			}

		} while (true);
		return false;
	}

	private void dealerTurn(Dealer dealer) {
		while(dealer.checkHand() <= 21) {
			System.out.println("Dealer hand is ");
			dealer.printHand();
			System.out.println(dealer.checkHand() + " total.");

			if (dealer.checkHand() < 17) {
				System.out.println("Dealer hits.");
				Card dealerCard = dealer.getCard();
				dealer.gameHand(dealerCard);

				if (dealer.checkBust()) {
					System.out.println("Dealer shows " + dealerCard);
					System.out.println(dealer.checkHand());
					System.out.println("Dealer busts.");
					break;
					
				}
			}
			if (dealer.checkHand() >= 17 && dealer.checkHand() <= 21) {
				System.out.println("Dealer stays.");
				break;
			}

		} 
	}

	private void endGame(Player player, Dealer dealer, boolean playerBust) {

		if (dealer.checkHand() > player.checkHand() || playerBust) {
			System.out.println("Dealer wins");
		} else if (dealer.checkHand() < player.checkHand()) {
			System.out.println("Player wins.");
		} else if (dealer.checkHand() == player.checkHand()) {
			System.out.println("It's a draw.");
		}

		System.out.println("Another hand?");
		String again = kb.nextLine();
		if (again.equalsIgnoreCase("no") || again.equalsIgnoreCase("n")) {
			quit = true;
		} else if (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y")) {
//			player.newHand();
//			dealer.newhand();
			quit = false;
		} else {
			System.err.println("That is not a valid input");
		}

	}
}
