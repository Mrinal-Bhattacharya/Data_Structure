package com.java.dp;

public class BinaryStringWithoutConsecutiveOne {

	// Let a[i] be the number of binary strings of length i which do not contain any
	// two consecutive 1’s and which end in 0. Similarly, let b[i] be the number of
	// such strings which end in 1. We can append either 0 or 1 to a string ending
	// in 0, but we can only append 0 to a string ending in 1
	static int countStrings(final int n) {
		final int[] a = new int[n], b = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n - 1] + b[n - 1];
	}

	// it is just a fab of n+2
	// n = 1, count = 2 = fib(3)
	// n = 2, count = 3 = fib(4)
	// n = 3, count = 5 = fib(5)
	// n = 4, count = 8 = fib(6)
	// n = 5, count = 13 = fib(7)
}
