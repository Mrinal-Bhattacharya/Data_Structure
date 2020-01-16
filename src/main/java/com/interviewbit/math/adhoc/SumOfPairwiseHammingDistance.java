package com.interviewbit.math.adhoc;

import java.util.List;

public class SumOfPairwiseHammingDistance {
	public int hammingDistance(int x, int y) {
		int result = 0;
		while ((x > 0) && (y > 0)) {
			result += (x % 2) ^ (y % 2);
			x >>= 1;
			y >>= 1;
		}
		return result;
	}

	public int hammingDistance(final List<Integer> A) {
		final int n = A.size();
		int dist = 0;
		for (int i = 0; i < 31; i++) {
			int oneCount = 0;
			for (int j = 0; j < n; j++) {
				final int num = A.get(j);
				oneCount += (num & (1 << i)) != 0 ? 1 : 0;
			}
			final int zeroCount = n - oneCount;
			dist += (2L * oneCount * zeroCount) % 1000000007;// We dont need modulo interviewbit ask for this 1000000007
			dist = dist % 1000000007;
		}
		return dist;
	}
}
