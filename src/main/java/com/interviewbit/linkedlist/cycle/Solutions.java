package com.interviewbit.linkedlist.cycle;

public class Solutions {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(final int x) {
			this.val = x;
			this.next = null;
		}
	}

	public ListNode detectCycle(final ListNode a) {
		ListNode slow = a;
		ListNode fast = a;

		while ((fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if ((slow == null) || (fast == null) || (slow != fast)) {
			return null;
		}

		slow = a;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public int detectCycleAndRemove(final ListNode a) {
		ListNode slow = a, fast = a;
		while ((slow != null) && (fast != null) && (fast.next != null)) {
			slow = slow.next;
			fast = fast.next.next;

			// If slow and fast meet at same point then loop is present
			if (slow == fast) {
				this.removeLoop(slow, a);
				return 1;
			}
		}
		return 0;
	}

	void removeLoop(final ListNode loop, final ListNode head) {
		ListNode ptr1 = loop;
		ListNode ptr2 = loop;
		int k = 1, i;
		// Count the number of nodes in loop
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}
		// Fix one pointer to head
		ptr1 = head;
		// And the other pointer to k nodes after head
		ptr2 = head;
		for (i = 0; i < k; i++) {
			ptr2 = ptr2.next;
		}
		// Move both pointers at the same pace, they will meet at loop starting node
		while (ptr2 != ptr1) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		// Get pointer to the last node
		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}
		ptr2.next = null;
	}
}
