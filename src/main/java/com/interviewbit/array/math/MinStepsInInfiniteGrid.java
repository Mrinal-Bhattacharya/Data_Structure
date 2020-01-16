package com.interviewbit.array.math;

import java.util.ArrayList;

public class MinStepsInInfiniteGrid {
	public int coverPoints(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		if (A.isEmpty() || B.isEmpty()) {
			return 0;
		}
		if (A.size() == 1) {
			return 0;
		}

		final int len = A.size();
		final int x = A.get(0);
		final int y = A.get(1);
		int count = 0;

		for (int i = 1; i < len; i++) {
			count += Math.max(Math.abs(A.get(i) - A.get(i - 1)), Math.abs(B.get(i) - B.get(i - 1)));
		}
		return count;
	}
}
