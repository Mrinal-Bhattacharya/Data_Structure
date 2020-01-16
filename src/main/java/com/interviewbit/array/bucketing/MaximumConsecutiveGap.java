package com.interviewbit.array.bucketing;

import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {
	public int maximumGap(final List<Integer> A) {

		final int n = A.size();
		if (n < 2) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, A.get(i));
			min = Math.min(min, A.get(i));
		}
		// n-1 buckets - we only care about max and min in each buckets
		final int[] bucketMaxima = new int[n - 1];
		Arrays.fill(bucketMaxima, Integer.MIN_VALUE);
		final int[] bucketMinima = new int[n - 1];
		Arrays.fill(bucketMinima, Integer.MAX_VALUE);
		// bucket width or bucketgaps like delta 1.33 then 1--2.33--3.66--4.99
		final float delta = (max - min) / ((float) n - 1);
		for (int i = 0; i < n; i++) {
			if ((A.get(i) == max) || (A.get(i) == min)) {
				continue;
			}
			final int bucketIndex = (int) Math.floor((A.get(i) - min) / delta);
			bucketMaxima[bucketIndex] = bucketMaxima[bucketIndex] == Integer.MIN_VALUE ? A.get(i)
					: Math.max(bucketMaxima[bucketIndex], A.get(i));
			bucketMinima[bucketIndex] = bucketMinima[bucketIndex] == Integer.MAX_VALUE ? A.get(i)
					: Math.min(bucketMinima[bucketIndex], A.get(i));
		}
		int prev = min;
		int maxGap = 0;
		for (int i = 0; i < (n - 1); i++) {
			// empty bucket according to Pigeonhole principle
			if (bucketMinima[i] == Integer.MAX_VALUE) {
				continue;
			}

			maxGap = Math.max(maxGap, bucketMinima[i] - prev);
			prev = bucketMaxima[i];
		}
		maxGap = Math.max(maxGap, max - prev);
		return maxGap;
	}
}
