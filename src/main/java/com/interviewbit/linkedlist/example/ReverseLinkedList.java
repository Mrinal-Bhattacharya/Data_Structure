package com.interviewbit.linkedlist.example;

import com.interviewbit.linkedlist.ListNode;

public class ReverseLinkedList {
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
