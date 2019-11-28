package com.interviewbit.string.tricks;

public class Solutions {
	public String longestPalindrome(final String A) {
		final int n = A.length();
		final boolean[][] palindrome = new boolean[n][n];
		int max_len = 1;
		int palindromeBeginAt = 0;
		for (int i = 0; i < n; i++) {
			palindrome[i][i] = true;
		}
		for (int i = 0; i < (n - 1); i++) {
			if (A.charAt(i) == A.charAt(i + 1)) {
				palindromeBeginAt = i;
				max_len = 2;
				palindrome[i][i + 1] = true;
			}
		}
		for (int currlen = 3; currlen <= n; currlen++) {
			for (int i = 0; i < ((n - currlen) + 1); i++) {
				final int j = (i + currlen) - 1;
				if ((A.charAt(i) == A.charAt(j)) && palindrome[i + 1][j - 1]) {
					palindromeBeginAt = i;
					max_len = currlen;
					palindrome[i][j] = true;
				}
			}
		}
		return A.substring(palindromeBeginAt, max_len + palindromeBeginAt);
	}

	public String solve(final String s) {
		final char[] T = new char[(s.length() * 2) + 3];
		T[0] = '$';
		T[(s.length() * 2) + 2] = '@';
		for (int i = 0; i < s.length(); i++) {
			T[(2 * i) + 1] = '#';
			T[(2 * i) + 2] = s.charAt(i);
		}
		T[(s.length() * 2) + 1] = '#';

		final int[] P = new int[T.length];
		int center = 0, right = 0;

		for (int i = 1; i < (T.length - 1); i++) {
			final int mirr = (2 * center) - i;

			if (i < right) {
				P[i] = Math.min(right - i, P[mirr]);
			}

			while (T[i + (1 + P[i])] == T[i - (1 + P[i])]) {
				P[i]++;
			}

			if ((i + P[i]) > right) {
				center = i;
				right = i + P[i];
			}
		}

		int length = 0;
		center = 0;
		for (int i = 1; i < (P.length - 1); i++) {
			if (P[i] > length) {
				length = P[i];
				center = i;
			}
		}
		return s.substring((center - 1 - length) / 2, ((center - 1) + length) / 2);
	}

	public int strStr(final String A, final String B) {
		if ((A == null) || (B == null)) {
			return -1;
		}
		for (int i = 0; i < ((A.length() - B.length()) + 1); i++) {
			int j;
			for (j = 0; j < B.length(); j++) {
				if (A.charAt(i + j) != B.charAt(j)) {
					break;
				}
			}
			if (j == B.length()) {
				return i;
			}
		}
		return -1;
	}
}
