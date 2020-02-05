package com.interviewbit.linkedlist.twopointer;

import com.interviewbit.linkedlist.ListNode;

public class ReverseLinkListII {
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
}
