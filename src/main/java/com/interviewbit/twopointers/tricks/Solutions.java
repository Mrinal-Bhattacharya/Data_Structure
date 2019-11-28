package com.interviewbit.twopointers.tricks;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
	public ArrayList<Integer> maxone(final ArrayList<Integer> A, final int B) {
		final ArrayList<Integer> result = new ArrayList<>();
		int wL = 0;
		int wR = 0;
		int nZero = 0;
		int bL = 0, bR = 0, bW = -1;
		while (wR < A.size()) {
			if (nZero <= B) {
				if (A.get(wR) == 0) {
					nZero++;
				}
				wR++;
			}
			if (nZero > B) {
				if (A.get(wL) == 0) {
					nZero--;
				}
				wL++;
			}
			if (((wR - wL)) > bW) {
				bW = wR - wL;
				bR = wR;
				bL = wL;
			}
		}
		for (int i = bL; i < bR; i++) {
			result.add(i);
		}
		return result;
	}

	int maxArea(final ArrayList<Integer> A) {
		int maxArea = 0; // Initializing maximum area as 0

		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				// Going through all pairs (i,j) for maximum container area.
				maxArea = Math.max(maxArea, Math.min(A.get(i), A.get(j)) * (j - i));
			}
		}
		return maxArea;
	}

	int maxArea2(final ArrayList<Integer> A) {
		int l = 0;
		int r = A.size() - 1;
		int area = 0;

		while (l < r) {
			// Calculating the max area
			area = Math.max(area, Math.min(A.get(l), A.get(r)) * (r - l));

			if (A.get(l) < A.get(r)) {
				l++;
			} else {
				r--;
			}
		}
		return area;
	}

	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int diff = Integer.MAX_VALUE; // Initialize min diff
		final int size_a = A.size(), size_b = B.size(), size_c = C.size();
		int i = 0, j = 0, k = 0;
		while ((i < size_a) && (j < size_b) && (k < size_c)) {
			final int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
			final int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
			if ((maximum - minimum) < diff) {
				diff = maximum - minimum;
			}
			if (diff == 0) {
				break;
			}
			if (A.get(i) == minimum) {
				i++;
			} else if (B.get(j) == minimum) {
				j++;
			} else {
				k++;
			}
		}
		return diff;
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(1);
		A.add(1);
		A.add(1);
		new Solutions().maxone(A, 0);
	}
}
