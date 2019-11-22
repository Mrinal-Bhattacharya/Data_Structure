package com.interviewbit.array.missingrepeatednumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
	public int firstMissingPositive(final ArrayList<Integer> A) {
		final int n = A.size();
		boolean firstExists = false;
		for (final Integer i : A) {
			if (i == 1) {
				firstExists = true;
			}
		}
		if (!firstExists) {
			return 1;
		}
		if (n == 1) {
			return 2;
		}
		for (int i = 0; i < n; i++) {
			if ((A.get(i) <= 0) || (A.get(i) > n)) {
				A.set(i, 1);
			}
		}
		for (int i = 0; i < n; i++) {
			final int v = Math.abs(A.get(i));
			// So we don't go out of bounds
			if (v == n) {
				A.set(0, -1 * Math.abs(A.get(0)));
			} else {
				A.set(v, -1 * Math.abs(A.get(v)));
			}
		}
		for (int i = 1; i < n; i++) {
			if (A.get(i) > 0) {
				return i;
			}
		}
		if (A.get(0) > 0) {
			return n;
		}
		return n + 1;

	}

	public ArrayList<Integer> repeatedNumber(final List<Integer> copy) {
		final List<Integer> A = new ArrayList<>();
		A.addAll(copy);
		final ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			final int abs = Math.abs(A.get(i));
			if (A.get(abs - 1) > 0) {
				A.set(abs - 1, -A.get(abs - 1));
			} else {
				out.add(abs);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > 0) {
				out.add(i + 1);
			}
		}
		return out;
	}

	public int duplicateNumber(final List<Integer> A) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (final Integer i : A) {
			if (map.containsKey(i)) {
				return i;
			}
			map.put(i, i);
		}
		return -1;
	}

	public int repeatedNumberNDiv3(final List<Integer> a) {
		if (a.size() < 2) {
			return a.get(0);
		}
		int count1 = 0, count2 = 0;

		// take the integers as the maximum
		// value of integer hoping the integer
		// would not be present in the array
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for (int i = 1; i < a.size(); i++) {

			// if this element is previously
			// seen, increment count1.
			if (first == a.get(i)) {
				count1++;
			} else if (second == a.get(i)) {
				count2++;
			} else if (count1 == 0) {
				count1++;
				first = a.get(i);
			}

			else if (count2 == 0) {
				count2++;
				second = a.get(i);
			}

			// if current element is different
			// from both the previously seen
			// variables, decrement both the
			// counts.
			else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		// Again traverse the array and
		// find the actual counts.
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == first) {
				count1++;
			} else if (a.get(i) == second) {
				count2++;
			}
		}

		if (count1 > (a.size() / 3)) {
			return first;
		}

		if (count2 > (a.size() / 3)) {
			return second;
		}

		return -1;
	}
}
