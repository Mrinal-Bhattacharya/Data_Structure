package com.interviewbit.twopointers.multiplearrays;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
	public void merge(final ArrayList<Integer> a, final ArrayList<Integer> b) {
		final int m = a.size();
		final int n = b.size();
		int i = 0, j = 0;
		while ((i < m) && (j < n)) {
			if (a.get(i) <= b.get(j)) {
				i++;
			} else {
				a.add(i, b.get(j));
				j++;
			}
		}
		while (j < n) {
			a.add(i, b.get(j));
			j++;
		}
	}

	public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		int i = 0;
		int j = 0;
		final ArrayList<Integer> ans = new ArrayList<>();
		while ((i < A.size()) && (j < B.size())) {
			if (A.get(i).equals(B.get(j))) {
				ans.add(A.get(i));
				i++;
				j++;
			} else if (A.get(i) < B.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return ans;
	}

	public static void main(final String[] args) {
		final List<Integer> A = new ArrayList<>();
		A.add(1000);
		final List<Integer> B = new ArrayList<>();
		B.add(1000);
		new Solutions().intersect(A, B);
	}
}
