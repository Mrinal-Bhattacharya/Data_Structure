package com.interviewbit.linkedlist.twopointer;

import com.interviewbit.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedList {
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
}
