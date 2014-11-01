package Poker;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackHand> {
	public BlackJackHand() {

	}

	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;

		for(int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}

	private ArrayList<Integer> possibleScores() {
		ArrayList<Integer> scores = new ArrayList<Integer>();
	}
}