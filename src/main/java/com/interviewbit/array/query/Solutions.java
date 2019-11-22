package com.interviewbit.array.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solutions {
	public ArrayList<Integer> solve(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		final int n = A.size();
		Stack<Integer> st = new Stack<>();
		final int[] left = new int[n];
		for (int i = 0; i < n; ++i) {
			while (!st.isEmpty() && (A.get(st.peek()) < A.get(i))) {
				st.pop();
			}
			left[i] = st.isEmpty() ? -1 : st.peek();
			st.push(i);
		}
		st = new Stack<>();
		final int[] right = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			while (!st.isEmpty() && (A.get(st.peek()) <= A.get(i))) {
				st.pop();
			}
			right[i] = st.isEmpty() ? n : st.peek();
			st.push(i);
		}
		final Map<Integer, Integer> prod = new HashMap<>();
		final List<int[]> counts = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			final int cnt = (i - left[i]) * (right[i] - i);
			final int a = A.get(i);
			Integer pr = prod.get(a);
			if (pr == null) {
				pr = this.toProd(a);
				prod.put(a, pr);
			}
			counts.add(new int[] { pr, cnt });
		}
		Collections.sort(counts, new Comparator<int[]>() {
			@Override
			public int compare(final int[] o1, final int[] o2) {
				return o2[0] - o1[0];
			}
		});
		final int[] vals = new int[n];
		final long[] bounds = new long[n];
		for (int i = 0; i < n; ++i) {
			final int[] c = counts.get(i);
			vals[i] = c[0];
			bounds[i] = c[1];
			if (i > 0) {
				bounds[i] += bounds[i - 1];
			}
			if (bounds[i] > (Integer.MAX_VALUE * 2L)) {
				bounds[i] = Integer.MAX_VALUE * 2L;
			}
		}
		final ArrayList<Integer> res = new ArrayList<>();
		for (final int q : B) {
			int pos = Arrays.binarySearch(bounds, q);
			if (pos < 0) {
				pos = -1 - pos;
			}
			res.add(vals[pos]);
		}
		return res;
	}

	private final static long b = (long) (1e9 + 7);

	private int toProd(final int a) {
		long res = a;
		for (int d = 2; (d * d) <= a; ++d) {
			if ((a % d) != 0) {
				continue;
			}
			final int m = ((d * d) == a) ? d : a;
			res = (res * m) % Solutions.b;
		}
		return (int) res;
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> as = new ArrayList<>();
		as.add(1);
		as.add(2);
		as.add(4);
		final ArrayList<Integer> qs = new ArrayList<>();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		qs.add(4);
		qs.add(5);
		qs.add(6);
		new Solutions().solve(as, qs);
	}
}
