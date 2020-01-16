package com.interviewbit.array.math;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
	public int maxArr(final ArrayList<Integer> A) {
		int result = 0;
		// Iterate through all pairs.
		for (int i = 0; i < A.size(); i++) {
			for (int j = i; j < A.size(); j++) {
				result = Math.max(result, Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j));
			}
		}
		return result;
	}

	/*
	 * f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are
	 * looking at max value, we don’t even care if the value becomes negative as
	 * long as we are also covering the max value in some way).
	 *
	 * (A[i] + i) - (A[j] + j) -(A[i] - i) + (A[j] - j) (A[i] - i) - (A[j] - j)
	 * (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
	 *
	 * Note that case 1 and 4 are equivalent and so are case 2 and 3.
	 *
	 * We can construct two arrays with values: A[i] + i and A[i] - i. Then, for
	 * above 2 cases, we find the maximum value possible. For that, we just have to
	 * store minimum and maximum values of expressions A[i] + i and A[i] - i for all
	 */
	public int maxArrInterviewBit(final ArrayList<Integer> A) {
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {

			// Updating max and min variables
			// as described in algorithm.
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		// Calculating maximum absolute difference.
		return Math.max(max1 - min1, max2 - min2);
	}
}
