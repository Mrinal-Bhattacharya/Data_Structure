package com.interviewbit.linkedlist.twopointer;

import com.interviewbit.linkedlist.ListNode;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, final int B) {
        final int l = this.size(A);
        final int stop = l - B;
        if (stop <= 0) {
            final ListNode newHead = A.next;
            A = null;
            return newHead;
        }

        int count = 1;
        ListNode curr = A;
        while (count != stop) {
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;

        return A;
    }

    public ListNode removeNthFromEnd2(ListNode A, final int B) {
        final ListNode head = A;
        if (A == null) {
            return null;
        }
        final int size = this.size(A);
        int count = 1;
        if (B >= size) {
            return A.next;
        }
        while (A != null) {
            if ((count + B) == size) {
                A.next = A.next.next;
                break;
            }
            A = A.next;
            count++;
        }
        return head;
    }

    public ListNode removeNthFromEnd3(final ListNode A, int B) {
        ListNode p = A;
        ListNode q = A;
        while (B > 0) {
            p = p.next;
            if (p == null) {
                return A.next;
            }
            B--;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return A;
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
