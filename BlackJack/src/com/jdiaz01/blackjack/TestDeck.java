package com.jdiaz01.blackjack;

public class TestDeck {

	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		for (Card card: myDeck.getCards()) {
			card.showCard();
		}
		
	}
}
