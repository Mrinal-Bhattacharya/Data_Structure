package com.interviewbit.array.arranging;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Solutions {
	public void rotate(final ArrayList<ArrayList<Integer>> a) {
		final int S = a.size() - 1;
		for (int i = 0; i < (a.size() / 2); i++) {
			for (int j = i; j < (S - i); j++) {
				// left bottom (2,0)
				final int temp1 = a.get(S - j).get(i);
				// right right bootom (2,2)
				final int temp2 = a.get(S - i).get(S - j);
				// right top (0,2)
				final int temp3 = a.get(j).get(S - i);
				// left top (0,0)
				final int temp4 = a.get(i).get(j);

				// swap
				a.get(i).set(j, temp1);
				a.get(S - j).set(i, temp2);
				a.get(S - i).set(S - j, temp3);
				a.get(j).set(S - i, temp4);
			}
		}
	}

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

	public int maxSpecialProduct(final List<Integer> A) {
		final int n = A.size();
		final int[] left = new int[n];
		final int[] right = new int[n];

		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(0);

		for (int i = 1; i < n; i++) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i)) {
					break;
				}
				q.removeLast();
			}
			left[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		q = new ArrayDeque<>();
		q.addLast(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!q.isEmpty()) {
				if (A.get(q.getLast()) > A.get(i)) {
					break;
				}
				q.removeLast();
			}
			right[i] = (q.isEmpty()) ? 0 : q.getLast();
			q.addLast(i);
		}
		long mx = -1;
		for (int i = 0; i < n; i++) {
			mx = Long.max(mx, 1L * left[i] * right[i]);
		}
		return (int) (mx % 1000000007);
	}

	// Driver code
	public static void main(final String args[]) {
		final Integer[] arr = new Integer[] { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
		System.out.print(new Solutions().maxSpecialProduct(Arrays.asList(arr)));
	}

}
