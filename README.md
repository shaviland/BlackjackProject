##  Blackjack

### Week Four Weekend Homework

### Overview
This app has a class structure that mimics a deck of cards, as well as a hand class to hold the cards. They are separate objects that can be implemented in multiple card based apps.

The main app has methods and fields in classes that mimic the functionality of shuffling and dealing a deck of cards. When a card is dealt  it is removed from the current deck.

Main game play:
Dealer class deals two hands of cards - one to a Dealer and another to a Player. If neither the Player or the Dealer have Blackjack, the Player's turn method is implemented.  The players is allowed to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack.

It currently doesn't have the multiple values for Ace. They are 11 for now.

After the player chooses to stay, the dealer's play method is initiated. The Dealer decides to Hit or Stay based on the rules of Blackjack: if the Dealer's hand total is below 17, the Dealer must Hit; if the hand total is 17 or above, the Dealer must Stay.

 The winner of each round is determined by implementing the remaining rules of Blackjack (such as going over 21) and comparing hand values. The Player is then prompted to either play another hand or quit.

 ### Technologies/ Topics applied
 Abstract Class and inheritance for the participants of the game.
 Objects classes for the card, deck, player, and dealer.
 Enums to dictate the traits of the cards.
 Do while and while loops to simulate the game play.
 If comparisons to figure out whether the Player or Dealer wins.

### Lessons Learned
building classes in an Object-Oriented manner hand having them communicate with one another.
Building classes whose fields are Objects.
Practice writing methods that interacted with each other to go through the game.
Use conditionals to create game logic.
