package com.java.dp;

import java.util.Arrays;

public class LongestIncressSeq {

	// Iterative function to find length of longest increasing sub-sequence
	// of given array
	public static int LIS(final int[] A) {
		// array to store sub-problem solution. L[i] stores the length
		// of the longest increasing sub-sequence ends with A[i]
		final int[] L = new int[A.length];
		final String[] paths = new String[A.length];
		// longest increasing sub-sequence ending with A[0] has length 1
		L[0] = 1;
		paths[0] = A[0] + " ";
		// start from second element in the array
		for (int i = 1; i < A.length; i++) {
			paths[i] = A[i] + " ";
			// do for each element in sub-array A[0..i-1]
			for (int j = 0; j < i; j++) {
				// find longest increasing sub-sequence that ends with A[j]
				// where A[j] is less than the current element A[i]
				if ((A[j] < A[i]) && (L[j] > L[i])) {
					L[i] = L[j];
					paths[i] = paths[j] + A[i] + " ";
				}
			}
			// include A[i] in LIS
			L[i]++;
		}
		final int maxLen = Arrays.stream(L).max().getAsInt();
		for (int k = 0; k < A.length; k++) {
			if (L[k] == maxLen) {
				System.out.println(paths[k]);
			}
		}
		// return longest increasing sub-sequence (having maximum length)
		return Arrays.stream(L).max().getAsInt();
	}

	public static int LIS(final int[] A, final int i, final int n, final int prev) {
		// Base case: nothing is remaining
		if (i == n) {
			return 0;
		}

		// case 1: exclude the current element and process the
		// remaining elements
		final int excl = LongestIncressSeq.LIS(A, i + 1, n, prev);

		// case 2: include the current element if it is greater
		// than previous element in LIS
		int incl = 0;
		if (A[i] > prev) {
			incl = 1 + LongestIncressSeq.LIS(A, i + 1, n, A[i]);
		}

		// return maximum of above two choices
		return Integer.max(incl, excl);
	}

	// main function
	public static void main(final String[] args) {
		final int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		// LIS(A,0,A.length,Integer.MIN_VALUE);
		System.out.println("Length of LIS is " + LongestIncressSeq.LIS(A));
	}
}
