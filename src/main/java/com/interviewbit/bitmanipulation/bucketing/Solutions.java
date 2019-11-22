package com.interviewbit.bitmanipulation.bucketing;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	public int findMinXor(final ArrayList<Integer> A) {
		Collections.sort(A);

		int minXor = Integer.MAX_VALUE;
		int val = 0;
		final int n = A.size();
		// calculate min xor of consecutive pairs
		for (int i = 0; i < (n - 1); i++) {
			val = A.get(i) ^ A.get(i + 1);
			minXor = Math.min(minXor, val);
		}

		return minXor;
	}
}
