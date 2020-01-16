package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solutions {
	public int nchoc(int A, final ArrayList<Integer> B) {
		final int MOD = 1000000007;
		final PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(final Integer o1, final Integer o2) {
				return o2 - o1;
			}
		});

		for (final Integer choc : B) {
			pq.add(choc);
		}

		long total = 0;

		while (A-- > 0) {
			final int choc = pq.poll();
			total += choc;
			total %= MOD;
			pq.add(choc / 2);
		}

		return (int) total;
	}

	public ListNode mergeKLists(final ArrayList<ListNode> a) {
		final PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(final ListNode o1, final ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (final ListNode node : a) {
			if (node != null) {
				pq.add(node);
			}
		}

		final ListNode node = new ListNode(-1);
		ListNode curr = node;

		while (!pq.isEmpty()) {
			final ListNode temp = pq.remove();
			curr.next = new ListNode(temp.val);
			curr = curr.next;

			if (temp.next != null) {
				pq.add(temp.next);
			}
		}

		return node.next;
	}

	public ArrayList<Integer> solve(final ArrayList<Integer> A, final ArrayList<Integer> B) {
		int n = A.size();
		final PriorityQueue<SumElement> pq = new PriorityQueue<>(new Comparator<SumElement>() {
			@Override
			public int compare(final SumElement o1, final SumElement o2) {
				return o2.sum - o1.sum;
			}
		});

		Collections.sort(A);
		Collections.sort(B);
		pq.add(new SumElement(A.get(n - 1) + B.get(n - 1), n - 1, n - 1));
		final ArrayList<Integer> ans = new ArrayList<>();
		final Set<String> set = new HashSet<>();
		set.add((n - 1) + "|" + (n - 1));
		while (n-- > 0) {
			final SumElement element = pq.poll();
			ans.add(element.sum);
			if (!set.contains((element.ind1 - 1) + "|" + (element.ind2))) {
				if ((element.ind1 - 1) >= 0) {
					pq.add(new SumElement(A.get(element.ind1 - 1) + B.get(element.ind2), element.ind1 - 1,
							element.ind2));
					set.add((element.ind1 - 1) + "|" + (element.ind2));
				}
			}

			if (!set.contains((element.ind1) + "|" + (element.ind2 - 1))) {
				if ((element.ind2 - 1) >= 0) {
					pq.add(new SumElement(A.get(element.ind1) + B.get(element.ind2 - 1), element.ind1,
							element.ind2 - 1));
					set.add((element.ind1) + "|" + (element.ind2 - 1));
				}
			}
		}

		return ans;
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		final ArrayList<Integer> B = new ArrayList<>();
		B.add(3);
		B.add(4);
		new Solutions().solve(A, B);
	}
}

class SumElement {
	int sum;
	int ind1;
	int ind2;

	public SumElement(final int sum, final int ind1, final int ind2) {
		this.sum = sum;
		this.ind1 = ind1;
		this.ind2 = ind2;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(final int x) {
		this.val = x;
		this.next = null;
	}
}
