package com.skilldistillery.blackjack;

public abstract class Participant {

	public abstract int checkHand();

	public abstract void printHand();
	
	public abstract boolean checkBlackJack();
		
	public abstract boolean checkBust();
	
	public abstract void newHand();

}
