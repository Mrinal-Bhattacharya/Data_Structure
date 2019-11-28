package com.interviewbit.hash.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solutions {
	public int colorful(final int A) {
		final Set<Integer> set = new HashSet<>();
		final String a = String.valueOf(A);

		for (int i = 0; i < a.length(); i++) {
			for (int j = i; j <= a.length(); j++) {
				final String numStr = a.substring(i, j);

				if (numStr.length() > 0) {
					final int mul = this.findProd(Integer.parseInt(numStr));
					if (set.contains(mul)) {
						return 0;
					}
					set.add(mul);
				}
			}
		}

		return 1;
	}

	public int findProd(int s) {
		int prd = 1;
		while (s > 0) {
			prd *= s % 10;
			s /= 10;
		}
		return prd;
	}

	public ArrayList<Integer> lszero(final ArrayList<Integer> a) {
		int start = 0, end = 0;
		final HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
			if (map.containsKey(sum)) {
				final int currStart = map.get(sum), currEnd = i;
				if (((currEnd - currStart) + 1) > ((end - start) + 1)) {
					start = currStart;
					end = currEnd;
				}
			} else {
				map.put(sum, i);
			}
		}
		// System.out.println(map);

		final ArrayList<Integer> result = new ArrayList<>();
		for (int i = start + 1; i <= end; i++) {
			result.add(a.get(i));
		}
		return result;
	}

	public ArrayList<Integer> twoSum(final List<Integer> A, final int B) {
		final ArrayList<Integer> ans = new ArrayList<>();

		final Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			if (map.containsKey(B - A.get(i))) {
				ans.add(map.get(B - A.get(i)));
				ans.add(i + 1);
				break;
			} else if (!map.containsKey(A.get(i))) {
				map.put(A.get(i), i + 1);
			}
		}

		return ans;
	}

	public static ArrayList<ArrayList<Integer>> fourSum(final ArrayList<Integer> a, final int b) {
		final HashSet<ArrayList<Integer>> set = new HashSet<>();
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		Collections.sort(a);

		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				int k = j + 1;
				int l = a.size() - 1;

				while (k < l) {
					final int sum = a.get(i) + a.get(j) + a.get(k) + a.get(l);
					if (sum > b) {
						l--;
					} else if (sum < b) {
						k++;
					} else if (sum == b) {
						final ArrayList<Integer> list = new ArrayList<>();
						list.add(a.get(i));
						list.add(a.get(j));
						list.add(a.get(k));
						list.add(a.get(l));
						if (!set.contains(list)) {
							set.add(list);
							ans.add(list);
						}
						k++;
						l--;
					}

				}
			}
		}

		return ans;
	}
}
