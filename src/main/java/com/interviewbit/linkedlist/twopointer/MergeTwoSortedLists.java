package com.interviewbit.linkedlist.twopointer;

import com.interviewbit.linkedlist.ListNode;

public class MergeTwoSortedLists {
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
}
