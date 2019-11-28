package com.interviewbit.hash.keyformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		final HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		final int n = a.size();
		new ArrayList<>();
		for (int i = 0; i < n; i++) {
			final char[] arr = a.get(i).toCharArray();
			Arrays.sort(arr);
			final String str = new String(arr);
			if (map.get(str) != null) {
				map.get(str).add(i + 1);
			} else {
				final ArrayList<Integer> g = new ArrayList<>();
				g.add(i + 1);
				map.put(str, g);
			}
		}

		for (final ArrayList<Integer> l : map.values()) {
			result.add(l);
		}
		return result;
	}

	public ArrayList<Integer> equal(final List<Integer> A) {
		final Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				final int sum = A.get(i) + A.get(j);
				if (map.containsKey(sum) && (map.get(sum).size() == 2)) {
					final int C1 = i;
					final int D1 = j;
					final int A1 = map.get(sum).get(0);
					final int B1 = map.get(sum).get(1);

					if ((A1 < B1) && (C1 < D1) && (A1 < C1) && (B1 != D1) && (B1 != C1)) {
						final ArrayList<Integer> temp = new ArrayList<>();
						temp.add(A1);
						temp.add(B1);
						temp.add(C1);
						temp.add(D1);

						ans.add(temp);
						final ArrayList<Integer> t = new ArrayList<>();
						map.put(sum, t);
					}
				} else if (!map.containsKey(sum)) {
					final ArrayList<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);

					map.put(sum, temp);
				}
			}

			Collections.sort(ans, new sort());
		}

		return ans.get(0);
	}

	public RandomListNode copyRandomList(final RandomListNode head) {

		if (head == null) {
			return null;
		}
		final HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		final RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode p = head;
		RandomListNode q = newHead;

		map.put(head, newHead);
		p = p.next;
		while (p != null) {
			final RandomListNode temp = new RandomListNode(p.label);
			map.put(p, temp);
			q.next = temp;
			q = temp;
			p = p.next;
		}
		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null) {
				q.random = map.get(p.random);
			} else {
				q.random = null;
			}
			p = p.next;
			q = q.next;
		}
		return newHead;

	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(final int x) {
		this.label = x;
	}
}

class sort implements Comparator<ArrayList<Integer>> {

	@Override
	public int compare(final ArrayList<Integer> o1, final ArrayList<Integer> o2) {
		int c = o1.get(0).compareTo(o2.get(0));
		if (c == 0) {
			c = o1.get(1).compareTo(o2.get(1));
		}
		if (c == 0) {
			c = o1.get(2).compareTo(o2.get(2));
		}
		if (c == 0) {
			c = o1.get(3).compareTo(o2.get(3));
		}

		return c;
	}

}