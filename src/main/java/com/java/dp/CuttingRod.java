package com.java.dp;

public class CuttingRod {
	static int cutRod(final int price[], final int n) {
		if (n <= 0) {
			return 0;
		}
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++) {
			max_val = Math.max(max_val, price[i] + CuttingRod.cutRod(price, n - i - 1));
		}

		return max_val;
	}

	static int cutRodDp(final int price[], final int n) {
		final int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return
		// the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			}
			val[i] = max_val;
		}

		return val[n];
	}

	public static void main(final String args[]) {
		final int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		final int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + CuttingRod.cutRod(arr, size));

	}
}
