package com.interviewbit.linkedlist.twopointer;

import com.interviewbit.linkedlist.ListNode;

public class RotateList {
    public ListNode rotateRight(final ListNode A, int B) {
        ListNode curr = A;
        ListNode head = null;
        while (B != 1) {
            curr = curr.next;
            B--;
        }
        head = curr.next;
        curr.next = null;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = A;
        return head;
    }

    public ListNode rotateRight2(final ListNode a, int b) {
        ListNode temp = a;
        final ListNode head = a;
        ListNode newHead = a;
        ListNode prev = null;
        final int totalSize = this.size(a);
        if (b != 0) {
            b = b % totalSize;
        }
        if (b == 0) {
            return newHead;
        }
        b = totalSize - b;
        temp = a;
        while ((temp != null) && (b != 0)) {
            b--;
            prev = temp;
            temp = temp.next;
        }
        if (prev == null) {
            return a;
        }
        prev.next = null;
        newHead = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
    public int size(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}
