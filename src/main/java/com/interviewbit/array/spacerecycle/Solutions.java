package com.interviewbit.array.spacerecycle;

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

	public int repeatedNumber(final List<Integer> A) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (final Integer i : A) {
			if (map.containsKey(i)) {
				return i;
			}
			map.put(i, i);
		}
		return -1;
	}

}
