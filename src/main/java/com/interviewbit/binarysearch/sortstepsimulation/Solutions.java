package com.interviewbit.binarysearch.sortstepsimulation;

public class Solutions {
	public int pow(final int x, int n, final int d) {
		if (n == 0) {
			return 1 % d;
		}

		long ans = 1, base = x;
		while (n > 0) {
			if ((n % 2) == 1) {
				ans = (ans * base) % d;
				n--;
			} else {
				base = (base * base) % d;
				n /= 2;
			}
		}
		if (ans < 0) {
			ans = (ans + d) % d;
		}
		return (int) ans;
	}
}
