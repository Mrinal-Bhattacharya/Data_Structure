package com.java.ds.basic.array;

import java.util.ArrayList;
import java.util.List;

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

	// Union of two sorted arrays
	public List<Integer> union(final int[] arr1, final int[] arr2, final int arr1Length, final int arr2Length) {
		final List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while ((i < arr1Length) && (j < arr2Length)) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				result.add(arr1[i]);
				i++;
			} else {
				result.add(arr2[j]);
				j++;
			}
		}
		while (i < arr1Length) {
			result.add(arr1[i]);
			i++;
		}
		while (j < arr2Length) {
			result.add(arr2[j]);
			j++;
		}
		return result;
	}

	// Intersection of two sorted arrays
	public List<Integer> intersection(final int[] arr1, final int[] arr2, final int arr1Length, final int arr2Length) {
		final List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while ((i < arr1Length) && (j < arr2Length)) {
			if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}

	public void test() {
		final int a = 61;
		final int n = 6;
		final int d = 1;
		final int b[] = { 62, 66, 63, 64, 65 };
		int sum = 0;
		for (int i = 0; i < b.length; i++) {
			sum += b[i];
		}
		final int actual = (n / 2) * (((2 * a) + ((n - 1) * d)));
		System.out.println(actual - sum);
	}

	public int missingNo(final int[] arr1, final int n) {
		// total=n*(n+1)/2
		final int j = n + 1;
		int total = (j * (j + 1)) / 2;
		// int total = ((n + 1) * (n + 2)) / 2;
		for (int i = 0; i < n; i++) {
			total -= arr1[i];
		}
		return total;
	}

	public int minDist(final int arr[], final int x, final int y) {
		int min_dist = Integer.MAX_VALUE;
		int i = 0;
		int prev = 0;
		for (; i < arr.length; i++) {
			if ((arr[i] == x) || (arr[i] == y)) {
				prev = i;
				break;
			}
		}
		for (; i < arr.length; i++) {
			if ((arr[i] == x) || (arr[i] == y)) {
				if (arr[i] != arr[prev]) {
					if (min_dist > (i - prev)) {
						min_dist = i - prev;
					}
				}
				prev = i;
			}
		}
		return min_dist;
	}
}