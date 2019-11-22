package com.interviewbit.array.spacerecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
	public void setZeroes(final ArrayList<ArrayList<Integer>> matrix) {
		boolean firstRow = false;
		boolean firstCol = false;

		for (int i = 0; i < matrix.size(); i++) {
			if (matrix.get(i).get(0) == 0) {
				firstCol = true;
				break;
			}
		}

		for (int i = 0; i < matrix.get(0).size(); i++) {
			if (matrix.get(0).get(i) == 0) {
				firstRow = true;
				break;
			}
		}

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(0).size(); j++) {
				if (matrix.get(i).get(j) == 0) {
					matrix.get(i).set(0, 0);
					matrix.get(0).set(j, 0);
				}
			}
		}

		for (int i = 1; i < matrix.size(); i++) {
			for (int j = 1; j < matrix.get(i).size(); j++) {
				if ((matrix.get(i).get(0) == 0) || (matrix.get(0).get(j) == 0)) {
					matrix.get(i).set(j, 0);
				}
			}
		}

		if (firstCol) {
			for (int i = 0; i < matrix.size(); i++) {
				matrix.get(i).set(0, 0);
			}
		}

		if (firstRow) {
			for (int i = 0; i < matrix.get(0).size(); i++) {
				matrix.get(0).set(i, 0);
			}
		}
	}

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

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();

		A.add(1);
		A.add(-2);
		A.add(-3);
		A.add(3);
		System.out.println(new Solutions().firstMissingPositive(A));

		final ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		final ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(0);
		arrayList.add(1);
		a.add(arrayList);
		final ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(1);
		arrayList2.add(1);
		arrayList2.add(1);
		a.add(arrayList2);
		final ArrayList<Integer> arrayList3 = new ArrayList<>();
		arrayList3.add(1);
		arrayList3.add(1);
		arrayList3.add(1);
		a.add(arrayList3);
		new Solutions().setZeroes(a);
	}
}
