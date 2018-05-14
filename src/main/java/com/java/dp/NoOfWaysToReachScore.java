package com.java.dp;

public class NoOfWaysToReachScore {
	// Consider a game where a player can score 3 or 5 or 10 points in a move. Given
	// a total score n, find number of ways to reach the given score.
	int count(final int target) {
		final int[] table = new int[target + 1];
		table[0] = 0;
		for (int i = 3; i < table.length; i++) {
			table[i] += table[i - 3];
		}
		for (int i = 5; i < table.length; i++) {
			table[i] += table[i - 5];
		}
		for (int i = 10; i < table.length; i++) {
			table[i] += table[i - 10];
		}
		return table[target];

	}
}
