package com.interviewbit.graph.adhoc;

import com.interviewbit.binarytree.TreeNode;
import com.interviewbit.linkedlist.ListNode;

public class ConvertSortedListToBinarySearchTree {
    static ListNode h;

    public TreeNode sortedListToBST(ListNode a) {
        if (a == null) return null;

        h = a;
        int len = getLength(a);
        return sortedListToBST(0, len - 1);
    }

    private TreeNode sortedListToBST(final int start, final int end) {
        if (start > end) return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    private int getLength(final ListNode a) {
        int len = 0;
        ListNode p = a;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    TreeNode sortedListToBSTUsingSlowFast(ListNode a) {
        if (a == null) return null;
        return helper(a, null);
    }

    private TreeNode helper(final ListNode head, final ListNode tail) {
        if (head == null || tail == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}

