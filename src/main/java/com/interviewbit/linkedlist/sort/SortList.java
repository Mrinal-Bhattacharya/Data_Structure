package com.interviewbit.linkedlist.sort;

import com.interviewbit.linkedlist.ListNode;

import java.util.Arrays;

public class SortList {
    public ListNode sortList(final ListNode A) {
        final int[] arr = new int[this.getLength(A)];
        ListNode curr = A;
        int i = 0;
        while (curr != null) {
            arr[i++] = curr.val;
            curr = curr.next;
        }
        Arrays.sort(arr);
        curr = A;
        i = 0;
        while (curr != null) {
            curr.val = arr[i++];
            curr = curr.next;
        }
        return A;
    }

    public int getLength(ListNode A) {
        int l = 0;
        while (A != null) {
            A = A.next;
            l++;
        }
        return l;
    }
}
