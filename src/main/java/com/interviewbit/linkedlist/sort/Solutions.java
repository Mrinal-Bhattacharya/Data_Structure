package com.interviewbit.linkedlist.sort;

import java.util.Arrays;

public class Solutions {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(final int x) {
			this.val = x;
			this.next = null;
		}
	}

	public ListNode partition(ListNode A, final int B) {
		final ListNode n1 = new ListNode(0);
		final ListNode n2 = new ListNode(0);

		ListNode curr1 = n1;
		ListNode curr2 = n2;

		while (A != null) {
			if (A.val < B) {
				curr1.next = new ListNode(A.val);
				curr1 = curr1.next;
			} else {
				curr2.next = new ListNode(A.val);
				curr2 = curr2.next;
			}
			A = A.next;
		}

		curr1.next = n2.next;

		return n1.next;
	}

	public ListNode insertionSortList(final ListNode A) {
		ListNode curr = A;
		while (curr != null) {
			ListNode temp = curr;
			ListNode swap = null;
			int minVal = Integer.MAX_VALUE;
			while (temp != null) {
				if (temp.val < minVal) {
					minVal = temp.val;
					swap = temp;
				}

				temp = temp.next;
			}
			swap.val = curr.val;
			curr.val = minVal;
			curr = curr.next;
		}
		return A;
	}

	// Need to work on merge sort sample
	public ListNode sortList(final ListNode A) {
		final int[] arr = new int[this.getLength(A)];
		ListNode curr = A;
		int i = 0;
		while (curr != null) {
			arr[i++] = curr.val;
			curr = curr.next;
		}

		Arrays.sort(arr);

		curr = A;
		i = 0;
		while (curr != null) {
			curr.val = arr[i++];
			curr = curr.next;
		}

		return A;
	}

	public int getLength(ListNode A) {
		int l = 0;
		while (A != null) {
			A = A.next;
			l++;
		}

		return l;
	}
}
