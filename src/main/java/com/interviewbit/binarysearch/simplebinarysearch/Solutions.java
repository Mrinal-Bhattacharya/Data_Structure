package com.interviewbit.binarysearch.simplebinarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {

	public int searchInsert2(final List<Integer> a, final int target) {
		int low = 0, high = a.size() - 1;
		if (a.get(low) > target) {
			return low;
		}
		if (a.get(high) < target) {
			return high + 1;
		}
		while (low <= high) {
			final int mid = low + ((high - low) / 2);
			if (a.get(mid) == target) {
				return mid;
			}
			if (target > a.get(mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public ArrayList<Integer> searchRange(final List<Integer> a, final int b) {
		final ArrayList<Integer> result = new ArrayList<>();
		result.add(this.binarySearch(a, b, true));
		result.add(this.binarySearch(a, b, false));
		return result;
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

	public int searchMatrix(final ArrayList<ArrayList<Integer>> a, final int b) {
		int row = 0, column = a.get(0).size() - 1; // set indexes for top right
		// element

		while ((row < a.size()) && (column >= 0)) {
			if (a.get(row).get(column) == b) {
				return 1;
			}
			if (a.get(row).get(column) > b) {
				column--;
			} else {
				row++;
			}
		}

		return 0;
	}

	public static void main(final String[] args) {
		final Integer[] arr = { 1, 2, 3, 4, 6, 7, 8, 9, 10, 11 };
		new Solutions().searchInsert2(Arrays.asList(arr), 5);
	}
}
