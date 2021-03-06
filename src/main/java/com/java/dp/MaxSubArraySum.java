package com.java.dp;

import java.util.List;

public class MaxSubArraySum {

    static void maxSubArraySum(final int[] a, final int size) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}
		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
	}

	public int maxSubArray(final List<Integer> A) {
		int maxEndingHere = A.get(0);
		int maxSoFar = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			maxEndingHere = Math.max(A.get(i), A.get(i) + maxEndingHere);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	// Driver code
	public static void main(final String[] args) {
        final int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		final int n = a.length;
		MaxSubArraySum.maxSubArraySum(a, n);
	}
}
