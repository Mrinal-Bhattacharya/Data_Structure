package com.interviewbit.math.example;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	public ArrayList<Integer> allFactors(final int A) {
		final ArrayList<Integer> result = new ArrayList<>();
		final double sqrt = Math.sqrt(A);
		for (int i = 1; i <= sqrt; i++) {
			if ((A % i) == 0) {
				result.add(i);
				if (i != sqrt) {
					result.add(A / i);
				}
			}
		}
		Collections.sort(result);
		return result;
	}

	public String findDigitsInBinary(int A) {
		if (A < 2) {
			return "" + A;
		}
		String str = "";
		int rem = 0;
		while (A > 0) {
			rem = A % 2;
			str = rem + str;
			A = A / 2;
		}
		return str;
	}

	public String findDigitsInDecimal(int A) {
		if (A < 10) {
			return "" + A;
		}
		String str = "";
		int rem = 0;
		while (A > 0) {
			rem = A % 10;
			str = rem + str;
			A = A / 10;
		}
		return str;
	}

	public int isPrime(final int A) {
		if (A == 1) {
			return 0;
		}
		final int upperLimit = (int) (Math.sqrt(A));
		for (int i = 2; i <= upperLimit; i++) {
			if ((A % i) == 0) {
				return 0;
			}
		}
		return 1;
	}

	public ArrayList<ArrayList<Integer>> squareSum(final int A) {
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (int a = 0; (a * a) < A; a++) {
			for (int b = 0; ((b * b) < A); b++) {
				if ((((a * a) + (b * b)) == A) && (a <= b)) {
					final ArrayList<Integer> newEntry = new ArrayList<>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}

	public ArrayList<Integer> sieve(final int A) {
		final int[] result = new int[A];
		for (int i = 2; i < A; i++) {
			result[i] = 1;
		}
		for (int i = 2; i <= Math.sqrt(A); i++) {
			for (int j = 2; (i * j) < A; j++) {
				result[i * j] = 0;
			}
		}
		final ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < A; i++) {
			if (result[i] == 1) {
				output.add(i);
			}
		}
		return output;
	}

}
