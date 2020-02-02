package com.interviewbit.string.programming;

public class Solutions {




	void computeLPS(final String s, final int[] lps) {
		final int m = s.length();
		int len = 0;
		lps[0] = 0;
		int i = 1;
		while (i < m) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	public int palindromLPS(final String a) {
		StringBuilder s = new StringBuilder(a);
		s = s.reverse();
		final String str = a + "$" + s.toString();
		final int[] lps = new int[str.length()];
		this.computeLPS(str, lps);
		return (a.length() - lps[str.length() - 1]);
	}
}
