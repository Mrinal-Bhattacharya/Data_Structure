package com.interviewbit.array.bucketing;

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
	public int solve(final ArrayList<Integer> A) {
		Collections.sort(A);
		final int n = A.size();
		for (int i = 0; i < (n - 1); i++) {
			if (A.get(i) == A.get(i + 1)) {
				continue;
			}
			if (A.get(i) == (n - i - 1)) {
				return 1;
			}
		}
		if (A.get(n - 1) == 0) {
			return 1;
		}
		return -1;
	}

	int nobleIntNaive(final int[] arr) {
		final int size = arr.length;
		for (int i = 0; i < size; i++) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				if (arr[i] < arr[j]) {
					count++;
				}
			}
			// If count of greater elements
			// is equal to arr[i]
			if (count == arr[i]) {
				return arr[i];
			}
		}
		return -1;
	}

}
