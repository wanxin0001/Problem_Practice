package Poker;

import java.util.ArrayList;

public class Hand <T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();

	public int score() {
		int score = 0;
		for (T card : cards) {
			score += card.value();
		}

		return score;
	}

	pubic void addCard(T card) {
		cards.add(card);
	}

	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}