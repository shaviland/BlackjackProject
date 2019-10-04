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
		playerTurn(player);
		dealerTurn(dealer);
		endGame(player, dealer);
		}while(!quit);

	}



	private void playerTurn(Player player) {
		do {
			System.out.println("Player hand is ");
			System.out.println(player.checkHand() + " total.");
			System.out.println("Hit or Stay?");
			String playerChoice = kb.nextLine();

			if (playerChoice.equalsIgnoreCase("hit")) {
				Card playerCard = dealer.getCard();
				player.gameHand(playerCard);
				if(player.checkBust()) {
					System.out.println("Player busts.");
					break;
				}
			} else if (playerChoice.equalsIgnoreCase("stay")) {
				break;
			}else {
				System.err.println("That is not a valid input.");
			}
			
		}while(true);
	}
	private void dealerTurn(Dealer dealer) {
		do {
		System.out.println("Dealer hand is ");
		System.out.println(dealer.checkHand() + " total.");
		Card dealerCard = dealer.getCard();
		dealer.gameHand(dealerCard);

		if(dealer.checkHand() < 17) {
			System.out.println("Dealer hits.");
			
			if(dealer.checkBust()) {
				System.out.println("Dealer busts.");
				break;
			}
		}else {
			break;
		}
		
	}while(true);
}
	private void endGame(Player player, Dealer dealer) {

		if(dealer.checkHand() > player.checkHand()) {
			System.out.println("Dealer wins");
		}else if(dealer.checkHand() < player.checkHand()) {
			System.out.println("Player wins.");
		}else {
			System.out.println("It's a draw.");
		}
		System.out.println("Another hand?");
		String again = kb.nextLine();
		if(again.equalsIgnoreCase("no") || again.equalsIgnoreCase("n")){
			quit = true;
		}else if(again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y")){
			player.newHand();
			dealer.newhand();
			quit = false;
		}else {
			System.err.println("That is not a valid input");
		}
				
	}
}