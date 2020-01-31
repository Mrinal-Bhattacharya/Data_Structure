package com.interviewbit.binarytree.bsttraversal;

import com.interviewbit.binarytree.TreeNode;

import java.util.Stack;

public class KthSmallestElementInTree {
	private int counter;

	public int kthsmallest(final TreeNode A, final int B) {
		return this.findKthSmallest(A, B).val;
	}

	public TreeNode findKthSmallest(final TreeNode root, final int k) {
		if (root == null) {
			return root;
		}

		// Traverse left subtree first
		final TreeNode left = this.findKthSmallest(root.left, k);
		// If we found kth node on left subtree
		if (left != null) {
			return left;
		}
		// If k becomes zero, that means we have traversed k nodes.
		if (++this.counter == k) {
			return root;
		}

		return this.findKthSmallest(root.right, k);
	}

	public int kthsmallest1(TreeNode A, int k) {
		final Stack<TreeNode> stack = new Stack<>();

		while (A != null) {
			stack.push(A);
			A = A.left;
		}

		while (k != 0) {
			final TreeNode n = stack.pop();
			k--;
			if (k == 0) {
				return n.val;
			}
			TreeNode right = n.right;

			while (right != null) {
				stack.push(right);
				right = right.left;
			}
		}

		return -1;
	}

	public int kthlargest(TreeNode A, int k) {
		final Stack<TreeNode> stack = new Stack<>();

		while (A != null) {
			stack.push(A);
			A = A.right;
		}

		while (k != 0) {
			final TreeNode n = stack.pop();
			k--;
			if (k == 0) {
				return n.val;
			}
			TreeNode left = n.left;

			while (left != null) {
				stack.push(left);
				left = left.right;
			}
		}

		return -1;
	}
}
