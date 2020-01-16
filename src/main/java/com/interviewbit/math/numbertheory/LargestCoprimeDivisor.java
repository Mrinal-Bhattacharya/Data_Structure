package com.interviewbit.math.numbertheory;

public class LargestCoprimeDivisor {
	public int cpFact(int A, final int B) {
		while (this.gcd(A, B) != 1) {
			A = A / this.gcd(A, B);
		}
		return A;
	}

	public int gcd(final int a, final int b) {
		if (a == 0) {
			return b;
		}
		return this.gcd(b % a, a);
	}
}
