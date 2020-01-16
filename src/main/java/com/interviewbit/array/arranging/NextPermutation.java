package com.interviewbit.array.arranging;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
	public ArrayList<Integer> nextPermutation(final ArrayList<Integer> A) {

		final int n = A.size();
		int k = -1;
		int l = 0;
		for (int i = 0; i < (n - 1); i++) {
			if (A.get(i) < A.get(i + 1)) {
				k = i;
			}
		}
		if (k == -1) {
			Collections.sort(A);
			return A;
		}
		for (int i = k + 1; i < n; i++) {
			if (A.get(i) > A.get(k)) {
				l = i;
			}
		}
		int temp = A.get(l);
		A.set(l, A.get(k));
		A.set(k, temp);
		int j = k + 1;
		int last = n - 1;
		while (j <= last) {
			temp = A.get(j);
			A.set(j, A.get(last));
			A.set(last, temp);
			j++;
			last--;
		}
		return A;
	}
}
