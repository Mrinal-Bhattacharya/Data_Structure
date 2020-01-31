package com.interviewbit.binarytree.bsttraversal;

import com.interviewbit.binarytree.TreeNode;

import java.util.Stack;

public class BSTIterator {
	public Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		this.stack = new Stack<>();
		while (root != null) {
			this.stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !(this.stack.isEmpty());
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = this.stack.pop();
		final int val = node.val;
		node = node.right;

		while (node != null) {
			this.stack.push(node);
			node = node.left;
		}

		return val;
	}
}
