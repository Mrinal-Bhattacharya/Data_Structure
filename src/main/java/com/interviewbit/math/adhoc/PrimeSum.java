package com.interviewbit.math.adhoc;

import java.util.ArrayList;

public class PrimeSum {
	public boolean[] sieve(final int A) {
		final boolean[] result = new boolean[A];
		for (int i = 0; i < A; i++) {
			result[i] = true;
		}
		for (int i = 2; i <= Math.sqrt(A); i++) {
			for (int j = 2; (i * j) < A; j++) {
				result[i * j] = false;
			}
		}
		return result;
	}

	public ArrayList<Integer> primesum(final int A) {
		final boolean[] sieve = this.sieve(A);
		final ArrayList<Integer> output = new ArrayList<>();
		for (int i = 2; i < (A / 2); i++) {
			if (sieve[i] == true) {
				if (sieve[A - i] == true) {
					output.add(i);
					output.add(A - i);
				}
			}
		}
		return output;
	}
}
