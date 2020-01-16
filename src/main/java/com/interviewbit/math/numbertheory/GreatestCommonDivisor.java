package com.interviewbit.math.numbertheory;

public class GreatestCommonDivisor {
	int euclid_gcd(final int a, final int b) {
		int dividend = a > b ? a : b;
		int divisor = a < b ? a : b;
		while (divisor != 0) {
			final int remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		return dividend;
	}

	public int gcd(final int a, final int b) {
		if (a == 0) {
			return b;
		}
		return this.gcd(b % a, a);
	}
}
