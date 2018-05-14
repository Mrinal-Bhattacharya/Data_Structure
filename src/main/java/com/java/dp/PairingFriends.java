package com.java.dp;

public class PairingFriends {
	int count(final int n) {
		if (n <= 2) {
			return n;
		}
		return this.count(n - 1) + ((n - 1) * (this.count(n - 2)));
	}

	int countDp(final int n) {
		final int[] count = new int[n + 1];
		count[0] = 0;
		count[1] = 1;
		count[2] = 2;
		for (int i = 3; i <= n; i++) {
			count[i] = count[i - 1] + ((i - 1) * count[i - 2]);
		}
		return count[n];
	}

	public static void main(final String[] args) {
		final int n = 4;
		System.out.println(new PairingFriends().countDp(n));
		System.out.println(new PairingFriends().count(n));

	}
}
