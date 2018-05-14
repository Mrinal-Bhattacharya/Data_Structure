package com.java.dp;

public class LongestCommonSubsequence {
	int lcs(final char[] X, final char[] Y, final int m, final int n) {
		if ((m == 0) || (n == 0)) {
			return 0;
		}
		if (X[m - 1] == Y[n - 1]) {
			return 1 + this.lcs(X, Y, m - 1, n - 1);
		} else {
			return Math.max(this.lcs(X, Y, m, n - 1), this.lcs(X, Y, m - 1, n));
		}
	}

	static int lcsDP(final char[] X, final char[] Y, final int m, final int n) {
		final int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if ((i == 0) || (j == 0)) {
					L[i][j] = 0;
				} else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					final int top = L[i - 1][j];
					final int left = L[i][j - 1];
					L[i][j] = Math.max(top, left);
				}
			}
		}
		/*
		 * For printing 2) Traverse the 2D array starting from L[m][n]. Do following for
		 * every cell L[i][j] …..a) If characters (in X and Y) corresponding to L[i][j]
		 * are same (Or X[i-1] == Y[j-1]), final then include this final character as
		 * part of LCS. …..b) Else compare values of L[i-1][j] and L[i][j-1] and final
		 * go in direction final of greater value.
		 */
		int i = m, j = n;
		int index = L[m][n];
		final char[] lcs = new char[index + 1];
		while ((i > 0) && (j > 0)) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (X[i - 1] == Y[j - 1]) {
				// Put current character in result
				lcs[index - 1] = X[i - 1];

				// reduce values of i, j and index
				i--;
				j--;
				index--;
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (L[i - 1][j] > L[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		for (int k = 0; k <= L[m][n]; k++) {
			System.out.print(lcs[k]);
		}

		return L[m][n];
	}

	public static void main(final String[] args) {
		final LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		final String s1 = "AGGTAF";
		final String s2 = "GXTXAYB";

		final char[] X = s1.toCharArray();
		final char[] Y = s2.toCharArray();
		final int m = X.length;
		final int n = Y.length;

		System.out.println(
				"Length of LCS is" + " " + lcs.lcs(X, Y, m, n) + " " + LongestCommonSubsequence.lcsDP(X, Y, m, n));
	}
}
