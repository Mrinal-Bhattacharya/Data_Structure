package com.interviewbit.linkedlist.example;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(final int x) {
		this.val = x;
		this.next = null;
	}
}

public class Solutions {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		final int m = this.size(a);
		final int n = this.size(b);

		if (m > n) {
			final int d = m - n;
			for (int i = 0; i < d; i++) {
				a = a.next;
			}
		} else if (n > m) {
			final int d = m - n;
			for (int i = 0; i < d; i++) {
				b = b.next;
			}
		}
		while ((a != null) && (b != null)) {
			if (a == b) {
				return a;
			}
			a = a.next;
			b = b.next;
		}
		return null;
	}

	public int size(ListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	public ListNode reverseList(final ListNode A) {
		ListNode next, current, prev;
		prev = null;
		current = A;
		next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
