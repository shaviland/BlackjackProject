package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;

public class Casino {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private static Scanner kb = new Scanner(System.in);
	private boolean quit = false;
	private boolean playerBust = false;
	private boolean dealerBust = false;

	public static void main(String[] args) {
		Casino cas = new Casino();

		cas.play();

	}

	private void play() {
		dealer.getDeck();
		do {
			System.out.println("Dealer is shuffling the deck");
			dealer.shuffle();
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
				dealer.printHand();
				System.out.println("Dealer: BlackJack");
				endGame(player, dealer, playerBust);
			}
			if(player.checkBlackJack()) {
				player.printHand();
				System.out.println("Player: BlackJack");
				endGame(player, dealer, playerBust);
			}
			playerTurn(player);
			
			if (!playerBust) {
				dealerTurn(dealer);
			}
			endGame(player, dealer, playerBust);
		} while (!quit);

	}

	private void playerTurn(Player player) {
		do {
			player.printHand();
			System.out.println(player.checkHand() + " total.");
			System.out.println("Hit or Stay?");
			String playerChoice = kb.nextLine();

			if (playerChoice.equalsIgnoreCase("hit")) {
				Card playerCard = dealer.getCard();
				player.gameHand(playerCard);
				if (player.checkBust()) {
					System.out.println("Player is dealt " + playerCard);
					player.printHand();
					System.out.println(player.checkHand());
					System.out.println("Player busts");
					playerBust = true;
					break;

				}
			} else if (playerChoice.equalsIgnoreCase("stay")) {
				break;
			} else {
				System.err.println("That is not a valid input.");
			}

		} while (true);
	}

	private void dealerTurn(Dealer dealer) {
		while(dealer.checkHand() <= 21) {
			dealer.printHand();
			System.out.println(dealer.checkHand() + " total.");

			while (dealer.checkHand() < 17) {
				System.out.println("Dealer hits");
				Card dealerCard = dealer.getCard();
				dealer.gameHand(dealerCard);
				dealer.printHand();
				System.out.println(dealer.checkHand());

				if (dealer.checkBust()) {
					System.out.println("Dealer busts");
					dealerBust = true;
					break;
					
				}
			}
			if (dealer.checkHand() >= 17 && dealer.checkHand() <= 21) {
				System.out.println("Dealer stays");
				break;
			}

		} 
	}

	private void endGame(Player player, Dealer dealer, boolean playerBust) {

		if (dealer.checkHand() > player.checkHand() && !dealerBust || playerBust) {
			System.out.println("Dealer wins");
		}
		if (dealer.checkHand() < player.checkHand() && !playerBust || dealerBust){
			System.out.println("Player wins");
		}
		if (dealer.checkHand() == player.checkHand()) {
			System.out.println("Push");
		}

		System.out.println("Another hand?");
		String again = kb.nextLine();
		if (again.equalsIgnoreCase("no") || again.equalsIgnoreCase("n")) {
			System.out.println("Goodbye.");
			quit = true;
		} else if (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y")) {
			player.newHand();
			dealer.newHand();
			quit = false;
		} else {
			System.err.println("That is not a valid input");
			quit = true;
		}

	}
}
