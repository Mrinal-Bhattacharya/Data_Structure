package com.interviewbit.linkedlist.pointermove;

import com.interviewbit.linkedlist.ListNode;

public class KReverseLinkedList {
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
}
