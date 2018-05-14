package com.interviewbit.math.adhoc;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
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

	public ArrayList<String> fizzBuzz(final int A) {
		final ArrayList<String> output = new ArrayList<>();
		for (int i = 1; i <= A; i++) {
			if (((i % 3) == 0) && ((i % 5) == 0)) {
				output.add("FizzBuzz");
				continue;
			}
			if ((i % 3) == 0) {
				output.add("Fizz");
				continue;
			}
			if ((i % 5) == 0) {
				output.add("Buzz");
				continue;
			}
			output.add("" + i);
		}
		return output;
	}

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

	public int hammingDistance(int x, int y) {
		int result = 0;
		while ((x > 0) && (y > 0)) {
			result += (x % 2) ^ (y % 2);
			x >>= 1;
			y >>= 1;
		}
		return result;
	}

	public int hammingDistance(final List<Integer> A) {
		final int n = A.size();
		int dist = 0;
		for (int i = 0; i < 31; i++) {
			int oneCount = 0;
			for (int j = 0; j < n; j++) {
				final int num = A.get(j);
				oneCount += (num & (1 << i)) != 0 ? 1 : 0;
			}
			final int zeroCount = n - oneCount;
			dist += (2L * oneCount * zeroCount) % 1000000007;// We dont need modulo interviewbit ask for this 1000000007
			dist = dist % 1000000007;
		}
		return dist;
	}

	public static void main(final String[] args) {
		final List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(5);
		System.out.println(new Solutions().hammingDistance(A));
	}
}
