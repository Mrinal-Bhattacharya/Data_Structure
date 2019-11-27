package com.interviewbit.binarysearch.sortmodification;

import java.util.List;

public class Solutions {
	public int search(final List<Integer> a, final int x) {

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

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		if (a.size() > b.size()) {
			return this.findMedianSortedArrays(b, a);
		}
		if (a.size() == 0) {
			return b.get(0);
		}
		final int x = a.size();
		final int y = b.size();
		int low = 0;
		int high = x;
		while (low <= high) {
			final int partitionX = (low + high) / 2;
			final int partitionY = ((x + y + 1) / 2) - partitionX;
			final int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a.get(partitionX - 1);
			final int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : a.get(partitionY - 1);
			final int minRightX = partitionX == x ? Integer.MAX_VALUE : a.get(partitionX);
			final int minRightY = partitionY == y ? Integer.MAX_VALUE : a.get(partitionY);
			if ((maxLeftX <= minRightY) && (maxLeftY <= minRightX)) {
				if (((x + y) % 2) == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(final String[] args) {
		// System.out.println(new Solutions().findMedianSortedArrays(Arrays.asList(x),
		// Arrays.asList(y)));
	}

}
