package com.interviewbit.linkedlist.sort;

import com.interviewbit.linkedlist.ListNode;

public class PartitionList {
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
}
