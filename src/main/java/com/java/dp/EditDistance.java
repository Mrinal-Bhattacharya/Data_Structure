package com.java.dp;

public class EditDistance {

	static int min(final int x, final int y, final int z) {
		if ((x <= y) && (x <= z)) {
			return x;
		}
		if ((y <= x) && (y <= z)) {
			return y;
		} else {
			return z;
		}
	}

	static int editDist(final String str1, final String str2, final int m, final int n) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (m == 0) {
			return n;
		}

		// If second string is empty, the only option is to
		// remove all characters of first string
		if (n == 0) {
			return m;
		}

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return EditDistance.editDist(str1, str2, m - 1, n - 1);
		}

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.
		// EditDistance.editDist(str1, str2, m, n - 1), Insert
		// EditDistance.editDist(str1, str2, m - 1, n), Remove
		// EditDistance.editDist(str1, str2, m - 1, n - 1) Replace
		return 1 + EditDistance.min(EditDistance.editDist(str1, str2, m, n - 1),
				EditDistance.editDist(str1, str2, m - 1, n), EditDistance.editDist(str1, str2, m - 1, n - 1));
	}

	static int editDistDP(final String str1, final String str2, final int m, final int n) {
		// Create a table to store results of subproblems
		// Plus one because for empty.
		final int dp[][] = new int[m + 1][n + 1];

		// Fill d[][] in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, only option is to
				// isnert all characters of second string
				if (i == 0) {
					dp[i][j] = j; // Min. operations = j
				} else if (j == 0) {
					dp[i][j] = i; // Min. operations = i
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + EditDistance.min(dp[i][j - 1], // Insert
							dp[i - 1][j], // Remove
							dp[i - 1][j - 1]); // Replace
				}
			}
		}

		return dp[m][n];
	}
}
