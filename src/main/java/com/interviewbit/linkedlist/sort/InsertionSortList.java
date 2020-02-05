package com.interviewbit.linkedlist.sort;

import com.interviewbit.linkedlist.ListNode;

public class InsertionSortList {
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
}
