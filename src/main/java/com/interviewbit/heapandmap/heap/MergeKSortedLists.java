package com.interviewbit.heapandmap.heap;

import com.interviewbit.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(final ArrayList<ListNode> a) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(final ListNode o1, final ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (final ListNode node : a) {
            if (node != null) {
                pq.add(node);
            }
        }

        final ListNode node = new ListNode(-1);
        ListNode curr = node;

        while (!pq.isEmpty()) {
            final ListNode temp = pq.remove();
            curr.next = new ListNode(temp.val);
            curr = curr.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return node.next;
    }
}
