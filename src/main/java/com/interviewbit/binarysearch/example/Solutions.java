package com.interviewbit.binarysearch.example;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
	public int findCount(final List<Integer> A, final int B) {
		if (A.size() == 1) {
			return A.get(0) == B ? 0 : -1;
		}
		final int first = this.binarySearch(A, B, true);
		final int last = this.binarySearch(A, B, false);
		if (last == -1) {
			return 0;
		}
		return (last - first) + 1;

	}

	int binarySearch(final List<Integer> A, final int B, final boolean searchFirst) {
		int result = -1, low = 0, high = A.size() - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (A.get(mid) == B) {
				result = mid;
				if (searchFirst == true) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (B < A.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	public int findMin(final List<Integer> a) {
		int low = 0, high = a.size() - 1;
		while (low <= high) {
			if (a.get(low) <= a.get(high)) {
				return a.get(low);
			}
			final int mid = (low + high) / 2;
			final int next = (mid + 1) % a.size();
			final int prev = (mid - 1) % a.size();
			if ((a.get(mid) <= a.get(next)) && (a.get(mid) <= a.get(prev))) {
				return a.get(mid);
			}
			if (a.get(mid) <= a.get(high)) {
				high = mid - 1;
			}
			if (a.get(mid) >= a.get(low)) {
				low = mid + 1;
			}
		}
		return -1;
	}

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

	public static void main(final String[] args) {
		final List<Integer> A = new ArrayList<>();
		A.add(1);
		new Solutions().findCount(A, 1);
	}
}
