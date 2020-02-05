package com.interviewbit.linkedlist.example;

import com.interviewbit.linkedlist.ListNode;

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        final int m = this.size(a);
        final int n = this.size(b);

        if (m > n) {
            final int d = m - n;
            for (int i = 0; i < d; i++) {
                a = a.next;
            }
        } else if (n > m) {
            final int d = m - n;
            for (int i = 0; i < d; i++) {
                b = b.next;
            }
        }
        while ((a != null) && (b != null)) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
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
