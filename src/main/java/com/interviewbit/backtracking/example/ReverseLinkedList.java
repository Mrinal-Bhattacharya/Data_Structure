package com.interviewbit.backtracking.example;

import com.interviewbit.linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        if(A == null || A.next == null){
            return A;
        }
        ListNode temp = reverseList(A.next);
        A.next.next = A;
        A.next = null;
        return temp;
    }
}
