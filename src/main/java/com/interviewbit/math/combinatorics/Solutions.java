package com.interviewbit.math.combinatorics;

public class Solutions {
	public int uniquePaths(final int A, final int B) {
		if ((A == 1) || (B == 1)) {
			return 1;
		}

		// If diagonal movements are allowed then
		// the last addition is required.
		return this.uniquePaths(A - 1, B) + this.uniquePaths(A, B - 1);
	}
}
