package com.java.ds.basic.array;

public class ArraySolutions {

	public int longestCommonSumSpan(final int[] arr1, final int[] arr2, final int arrLength) {
		int maxSpan = 0;
		for (int i = 0; i < arrLength; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = i; j < arrLength; j++) {
				sum1 += arr1[j];
				sum2 += arr2[j];
				if (sum1 == sum2) {
					final int length = (j - i) + 1;
					if (length > maxSpan) {
						maxSpan = length;
					}
				}
			}
		}
		return maxSpan;
	}

	// 1) Since there are total n elements, maximum sum is n for both arrays.

	// 2) Difference between two sums varies from -n to n. So there are total 2n
	// + 1 possible values of difference.

	// 3) If differences between prefix sums of two arrays become same at two
	// points, then subarrays between these two points have same sum.

	// Using Auxiliary Array

	public int longestCommonSumSpan2(final int[] arr1, final int[] arr2, final int length) {
		int maxSpan = 0;
		int prevSum1 = 0;
		int prevSum2 = 0;
		final int diff[] = new int[(2 * length) + 1];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = -1;
		}
		for (int i = 0; i < length; i++) {
			prevSum1 += arr1[i];
			prevSum2 += arr2[i];
			final int curr_diff = prevSum1 - prevSum2;
			final int diff_index = length + curr_diff;
			if (curr_diff == 0) {
				maxSpan = i + 1;
			} else if (diff[diff_index] == -1) {
				diff[diff_index] = i;
			} else {
				final int len = i - diff[diff_index];
				if (len > maxSpan) {
					maxSpan = len;
				}
			}

		}
		return maxSpan;
	}

}
