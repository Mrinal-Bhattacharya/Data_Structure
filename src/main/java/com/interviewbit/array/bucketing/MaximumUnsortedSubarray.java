package com.interviewbit.array.bucketing;

import java.util.ArrayList;

public class MaximumUnsortedSubarray {
	public ArrayList<Integer> subUnsort(final ArrayList<Integer> A) {
		final ArrayList<Integer> list = new ArrayList<>();
		int st = -1, end = -1;
		// from left
		for (int i = 1; i < A.size(); ++i) {
			if (A.get(i) < A.get(i - 1)) {
				st = i - 1;
				break;
			}
		}
		// fully sorted
		if (st == -1) {
			list.add(-1);
			return list;
		}
		// from right
		for (int i = A.size() - 2; i >= 0; --i) {
			if (A.get(i) > A.get(i + 1)) {
				end = i + 1;
				break;
			}
		}
		// find min and max in the range [st, end]
		int min = A.get(st);
		int max = A.get(st);
		for (int i = st; i <= end; ++i) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}
		for (int i = 0; i < st; ++i) {
			if (A.get(i) > min) {
				st = i;
				break;
			}
		}
		for (int i = A.size() - 1; i >= (end + 1); --i) {
			if (A.get(i) < max) {
				end = i;
				break;
			}
		}
		list.add(st);
		list.add(end);
		return list;
	}
}
