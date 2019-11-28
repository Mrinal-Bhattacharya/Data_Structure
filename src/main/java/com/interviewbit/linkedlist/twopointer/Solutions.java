package com.interviewbit.linkedlist.twopointer;

public class Solutions {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(final int x) {
			this.val = x;
			this.next = null;
		}
	}

	public int lPalin(final ListNode head) {
		if ((head == null) || (head.next == null)) {
			return 1;
		}
		int l = 0;
		ListNode curr = head;

		while (curr != null) {
			l++;
			curr = curr.next;
		}

		int i = 1;
		curr = head;

		while (i < (l / 2)) {
			curr = curr.next;
			i++;
		}

		ListNode mid = this.reverse(curr.next);

		curr = head;

		while (mid != null) {
			if (curr.val != mid.val) {
				return 0;
			}
			curr = curr.next;
			mid = mid.next;
		}

		return 1;
	}

	public ListNode reverse(final ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public ListNode deleteDuplicates(final ListNode A) {
		ListNode curr = A;
		while (curr.next != null) {
			if (curr.next.val == curr.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return A;
	}

	public ListNode deleteDuplicates2(final ListNode A) {
		final ListNode dummy = new ListNode(0);
		dummy.next = A;
		ListNode prev = dummy;
		ListNode current = A;
		while (current != null) {
			while ((current.next != null) && (prev.next.val == current.next.val)) {
				current = current.next;
			}
			if (prev.next == current) {
				prev = prev.next;
			} else {
				prev.next = current.next;
			}
			current = current.next;
		}
		return dummy.next;

	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode dummy = new ListNode(0);
		final ListNode head = dummy;
		while ((A != null) && (B != null)) {
			if (A.val < B.val) {
				dummy.next = A;
				A = A.next;
			} else {
				dummy.next = B;
				B = B.next;
			}
			dummy = dummy.next;
		}
		if (A != null) {
			dummy.next = A;
		}
		if (B != null) {
			dummy.next = B;
		}
		return head.next;
	}

	public ListNode removeNthFromEnd(ListNode A, final int B) {
		final int l = this.size(A);
		final int stop = l - B;
		if (stop <= 0) {
			final ListNode newHead = A.next;
			A = null;
			return newHead;
		}

		int count = 1;
		ListNode curr = A;
		while (count != stop) {
			curr = curr.next;
			count++;
		}

		curr.next = curr.next.next;

		return A;
	}

	public ListNode removeNthFromEnd2(ListNode A, final int B) {
		final ListNode head = A;
		if (A == null) {
			return null;
		}
		final int size = this.size(A);
		int count = 1;
		if (B >= size) {
			return A.next;
		}
		while (A != null) {
			if ((count + B) == size) {
				A.next = A.next.next;
				break;
			}
			A = A.next;
			count++;
		}
		return head;
	}

	public ListNode removeNthFromEnd3(final ListNode A, int B) {
		ListNode p = A;
		ListNode q = A;
		while (B > 0) {
			p = p.next;
			if (p == null) {
				return A.next;
			}
			B--;
		}

		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;
		return A;
	}

	public int size(ListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	public ListNode rotateRight(final ListNode A, int B) {
		ListNode curr = A;
		ListNode head = null;
		while (B != 1) {
			curr = curr.next;
			B--;
		}

		head = curr.next;
		curr.next = null;

		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = A;

		return head;
	}

	public ListNode rotateRight2(final ListNode a, int b) {
		ListNode temp = a;
		final ListNode head = a;
		ListNode newHead = a;
		ListNode prev = null;
		final int totalSize = this.size(a);
		if (b != 0) {
			b = b % totalSize;
		}
		if (b == 0) {
			return newHead;
		}
		b = totalSize - b;
		temp = a;
		while ((temp != null) && (b != 0)) {
			b--;
			prev = temp;
			temp = temp.next;
		}
		if (prev == null) {
			return a;
		}
		prev.next = null;
		newHead = temp;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;

		return newHead;
	}

	public ListNode reverseBetween(final ListNode A, final int B, final int C) {
		if ((A == null) || (B == C)) {
			return A;
		}

		final ListNode fakeHead = new ListNode(-1);
		fakeHead.next = A;
		int pos = 1;
		// go m-1 places
		ListNode start = fakeHead;
		ListNode curr = A;
		while (pos < B) {
			start = curr;
			curr = curr.next;
			pos++;
		}

		// reverse n posits
		ListNode prev = null;
		final ListNode tail = curr;
		while (pos <= C) {
			final ListNode future = curr.next;
			curr.next = prev;
			prev = curr;
			curr = future;
			pos++;
		}
		start.next = prev;
		tail.next = curr;
		return fakeHead.next;
	}

	public ListNode reorderList(final ListNode A) {
		if ((A == null) || (A.next == null)) {
			return A;
		}
		final int l = this.size(A);
		int count = 1;
		final int stop = (l % 2) == 0 ? l / 2 : (l / 2) + 1;
		ListNode curr = A;
		while (count < stop) {
			curr = curr.next;
			count++;
		}

		ListNode half = this.reverseList(curr.next);
		curr.next = null;

		curr = A;
		while (half != null) {
			final ListNode temp = new ListNode(half.val);
			temp.next = curr.next;
			curr.next = temp;

			curr = curr.next.next;
			half = half.next;
		}

		return A;
	}

	public ListNode reverseList(final ListNode A) {
		ListNode next = null;
		ListNode prev = null;
		ListNode curr = A;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
}
