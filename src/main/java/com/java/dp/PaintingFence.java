package com.java.dp;

public class PaintingFence {
	int numWays(final int n, final int k) {
		if (n == 1) {
			return k;
		}
		if (n == 2) {
			return k * k;
		}
		if (k < 2) {
			return 0;
		}
		if (n == 3) {
			return k * ((k - 1) + ((k - 1) * k));
		} else {
			return (k * this.numWays(n - 1, k)) - (this.numWays(n - 3, k) * (k - 1));
		}
	}

	long countWays(final int n, final int k) {
		if ((n <= 1) || (k <= 0)) {
			return n * k;
		}
		final int[] dp = new int[n + 1]; // index based : 1
		dp[0] = 0;
		dp[1] = k;
		dp[2] = k + (k * (k - 1));
		for (int i = 3; i <= n; i++) {
			dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
		}
		return dp[n];
	}

	long countWayss(final int n, final int k) {
		// There are k ways to color first post
		long total = k;

		// There are 0 ways for single post to
		// violate (same color_ and k ways to
		// not violate (different color)
		long same = 0, diff = k;

		// Fill for 2 posts onwards
		for (int i = 2; i <= n; i++) {
			// Current same is same as previous diff
			same = diff;

			// We always have k-1 choices for next post
			diff = total * (k - 1);

			// Total choices till i.
			total = (same + diff);
		}

		return total;
	}
}
