package com.interviewbit.linkedlist.pointermove;

import com.interviewbit.linkedlist.ListNode;

public class SwapListNodesInPairs {
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
