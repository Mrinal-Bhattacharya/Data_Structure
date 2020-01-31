package com.java.dp;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    /* Driver program to test above function */
    public static void main(final String[] args) {
        final int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
        final int n = arr.length;
        System.out.println("Sum of maximum sum increasing " + " subsequence is " + new MaximumSumIncreasingSubsequence().maxSumIS(arr, n));
    }

    int maxSumIS(final int[] arr, final int n) {
		final int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			sum[i] = arr[i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if ((arr[j] < arr[i]) && ((sum[j] + arr[i]) > sum[i])) {
					sum[i] = sum[j] + arr[i];
				}
			}
		}
		return Arrays.stream(sum).max().getAsInt();
	}
}
