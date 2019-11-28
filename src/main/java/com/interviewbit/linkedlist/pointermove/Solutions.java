package com.interviewbit.linkedlist.pointermove;

public class Solutions {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(final int x) {
			this.val = x;
			this.next = null;
		}
	}

	public ListNode reverseList(final ListNode A, final int B) {
		ListNode current = A;
		ListNode next = null;
		ListNode prev = null;

		int count = 0;

		while ((count < B) && (current != null)) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			A.next = this.reverseList(next, B);
		}

		return prev;
	}

	public ListNode swapPairs(ListNode A) {
		if ((A == null) || (A.next == null)) {
			return A;
		}
		final ListNode head = A.next;
		ListNode prev = null;

		while ((A != null) && (A.next != null)) {
			final ListNode temp = A.next;
			A.next = A.next.next;
			temp.next = A;

			if (prev != null) {
				prev.next = temp;
			}
			prev = A;

			A = A.next;
		}

		return head;
	}
}
