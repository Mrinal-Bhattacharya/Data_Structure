package com.interviewbit.twopointers.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
	public int threeSumClosest(final ArrayList<Integer> A, final int B) {
		int low, high, mid;
		Collections.sort(A);
		final int n = A.size();
		int res = A.get(0) + A.get(1) + A.get(2);

		if (n == 3) {
			return res;
		}
		int sum;
		for (low = 0; low < (n - 2); low++) {
			mid = low + 1;
			high = n - 1;
			final int num = B - A.get(low);
			while (mid < high) {
				sum = A.get(mid) + A.get(high);
				if (sum == num) {
					return B;
				} else if (sum < num) {
					mid++;
				} else {
					high--;
				}
				final int diff = Math.abs(sum - num);
				final int otherDiff = Math.abs(res - B);
				if (diff < otherDiff) {
					res = sum + A.get(low);
				}
			}
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> threeSum(final List<Integer> A) {

		Collections.sort(A);
		final Map<String, Integer> x = new HashMap<>();
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < (A.size() - 2); i++) {
			int start = i + 1;
			int end = A.size() - 1;
			while (start < end) {
				if ((A.get(i) + A.get(start) + A.get(end)) == 0) {
					arr = new ArrayList<>();
					arr.add(A.get(i));
					arr.add(A.get(start));
					arr.add(A.get(end));
					if (x.containsKey("" + A.get(i) + A.get(start) + A.get(end))) {
						x.put("" + A.get(i) + A.get(start) + A.get(end), 0);
						ans.add(arr);
					}
					start++;
					end--;
				} else if ((A.get(i) + A.get(start) + A.get(end)) < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return ans;

	}

	public int diffPossible(final ArrayList<Integer> A, final int B) {
		int i = 0, j = 1;
		final int size = A.size();
		while ((i < size) && (j < size)) {
			if ((i != j) && ((A.get(j) - A.get(i)) == B)) {
				return 1;
			} else if ((A.get(j) - A.get(i)) < B) {
				j++;
			} else {
				i++;
			}
		}
		return 0;
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> a = new ArrayList<>();
		a.add(-1);
		a.add(-1);
		a.add(0);

	}
}