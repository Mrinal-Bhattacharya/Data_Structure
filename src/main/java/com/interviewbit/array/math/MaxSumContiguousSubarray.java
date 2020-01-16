package com.interviewbit.array.math;

import java.util.List;

public class MaxSumContiguousSubarray {
	public int maxSubArray(final List<Integer> A) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, s = 0;
		final int size = A.size();

		for (int i = 0; i < size; i++) {
			max_ending_here += A.get(i);

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		return max_so_far;
	}
}
