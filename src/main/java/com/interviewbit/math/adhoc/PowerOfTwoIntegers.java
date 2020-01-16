package com.interviewbit.math.adhoc;

public class PowerOfTwoIntegers {
	public int isPower(final int A) {
		if (A == 1) {
			return 1;
		}
		final int sqrt = (int) Math.sqrt(A);
		int j = 0;
		for (int i = 2; i <= sqrt; i++) {
			j = 0;
			while (((A % i) == 0) && (j <= sqrt)) {
				if (Math.pow(i, j) == A) {
					return 1;
				}
				j++;
			}
		}
		return 0;
	}
}
