package com.interviewbit.binarysearch.example;

import java.util.List;

public class Solutions {


	int circularArraySearch(final List<Integer> a, final int x) {
		int low = 0, high = a.size() - 1;
		while (low <= high) {
			final int mid = (low + high) / 2;
			if (a.get(mid) == x) {
				return mid;
			}
			if (a.get(mid) <= a.get(high)) {
				if ((x > a.get(mid)) && (x <= a.get(high))) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if ((x >= a.get(low)) && (x < a.get(mid))) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

}
