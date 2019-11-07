package com.interviewbit.math.numbertheory;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solutions {
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

	public int trailingZeroes(final int A) {
		// Initialize result
		int count = 0;
		// Keep dividing n by powers
		// of 5 and update count
		for (int i = 5; (A / i) >= 1; i *= 5) {
			count += A / i;
		}
		return count;
	}

	public int findRank(final String s) {
		final int m = 1000003;
		final int n = s.length();
		final int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] * i;
			f[i] %= m;
		}

		int rank = 0;

		final SortedSet<Character> set = new TreeSet<>();
		for (int i = n - 1; i >= 0; i--) {
			final char c = s.charAt(i);
			final int before = set.headSet(c).size();
			System.out.println(s.charAt(i) + " Before " + before);
			System.out.println(before);
			final int fact = f[n - i - 1];
			System.out.println("Fact " + fact);
			rank += before * fact;
			rank %= m;

			set.add(c);
		}

		return rank + 1;
	}

	public void rank(final String A) {
		final int n = A.length();
		final SortedSet<Character> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			set.add(A.charAt(i));
		}
		final int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] * i;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			final int before = set.headSet(A.charAt(i)).size();
			System.out.println(A.charAt(i) + " Before " + before);
			final int fact = f[n - i - 1];
			System.out.println("Fact " + fact);
			result = (before * fact) + result;
		}
		System.out.println(result);
	}

	public static void main(final String[] args) {
		// new Solutions().rank("SPARK");
		System.out.println(new Solutions().rankRep("sadasdsasassasas"));
		final SortedSet<Character> set = new TreeSet<>();
		set.add('A');
		set.add('B');
		// set.add('C');
		set.add('D');
		set.add('E');
		set.add('F');
		System.out.println(set.headSet('C'));

		final SortedSet<Integer> set1 = new TreeSet<>();
		set1.add(1);
		set1.add(2);
		// set.add('C');
		set1.add(4);
		set1.add(5);
		set1.add(6);
		System.out.println(set1.headSet(3));
	}

	public int rankRep(final String A) {
		int rank = 0;
		final int n = A.length();
		for (int i = 0; i < n; i++) {
			final char ch = A.charAt(i);
			final int smallerToRight = this.smallerToRight(A, ch, i);
			final BigInteger factorial = this.factorial(BigInteger.valueOf(n - 1 - i));
			final BigInteger factorialsOfDuplictes = this.factorialsOfDuplictes(A, i);
			if (factorialsOfDuplictes.intValue() > 1) {
				rank = rank + (factorial.multiply(BigInteger.valueOf(smallerToRight)).divide(factorialsOfDuplictes))
						.intValue();
			} else {
				rank = rank + (factorial.multiply(BigInteger.valueOf(smallerToRight))).intValue();
			}
		}
		return rank + 1;
	}

	private BigInteger factorialsOfDuplictes(final String str, final int i) {
		BigInteger result = BigInteger.ONE;
		final Map<Character, Integer> map = new HashMap<>();
		for (int k = i; k < str.length(); k++) {
			map.put(str.charAt(k), map.getOrDefault(str.charAt(k), 0) + 1);
		}
		final Collection<Integer> values = map.values();
		for (final Integer value : values) {

			if (value > 1) {
				final BigInteger factorial = this.factorial(BigInteger.valueOf(value));
				result = result.multiply(factorial);
			}
		}
		return result;
	}

	BigInteger factorial(final BigInteger n) {
		if (n.intValue() == 0) {
			return BigInteger.ONE;
		}

		return n.multiply(this.factorial(n.subtract(BigInteger.ONE)));
	}

	private int smallerToRight(final String a, final char ch, final int positionToStart) {
		final int intCh = ch;
		int result = 0;
		for (int i = positionToStart + 1; i < a.length(); i++) {
			if (a.charAt(i) < intCh) {
				result++;
			}
		}
		return result;
	}

	public int cpFact(int A, final int B) {
		while (this.gcd(A, B) != 1) {
			A = A / this.gcd(A, B);
		}
		return A;
	}

}
