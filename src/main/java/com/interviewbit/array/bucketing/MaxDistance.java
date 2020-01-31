package com.interviewbit.array.bucketing;

import java.util.List;

public class MaxDistance {
	public int maximumGap(final List<Integer> A) {
		if (A.size() < 2) {
			return 0;
		}
		int maxDiff;
		int i, j;
		final int n = A.size();
        final int[] RMax = new int[A.size()];
        final int[] LMin = new int[A.size()];
		LMin[0] = A.get(0);
		for (i = 1; i < n; ++i) {
			LMin[i] = Math.min(A.get(i), LMin[i - 1]);
		}
		RMax[n - 1] = A.get(n - 1);
		for (j = n - 2; j >= 0; --j) {
			RMax[j] = Math.max(A.get(j), RMax[j + 1]);
		}
		i = 0;
		j = 0;
		maxDiff = -1;
		while ((j < n) && (i < n)) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else {
				i = i + 1;
			}
		}

		return maxDiff;
	}
}
