package com.java.dp;

public class Knapsack {

    static int knapSack(final int W, final int[] wt, final int[] val, final int n) {
		// Base Case
		if ((n == 0) || (W == 0)) {
			return 0;
		}

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (wt[n - 1] > W) {
			return Knapsack.knapSack(W, wt, val, n - 1);
		} else {
			return Math.max(val[n - 1] + Knapsack.knapSack(W - wt[n - 1], wt, val, n - 1),
					Knapsack.knapSack(W, wt, val, n - 1));
		}
	}

    static int knapSackDp(final int W, final int[] wt, final int[] val, final int n) {
		int i, w;
        final int[][] K = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if ((i == 0) || (w == 0)) {
					K[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
		}

		return K[n][W];
	}

	// Driver program to test above function
    public static void main(final String[] args) {
        final int[] val = new int[]{60, 100, 120};
        final int[] wt = new int[]{1, 2, 4};
		final int W = 5;
		final int n = val.length;
		System.out.println(Knapsack.knapSackDp(W, wt, val, n));
	}
}
