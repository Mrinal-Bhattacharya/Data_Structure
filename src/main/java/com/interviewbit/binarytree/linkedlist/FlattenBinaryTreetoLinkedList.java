package com.interviewbit.binarytree.linkedlist;

import java.util.Stack;

import com.interviewbit.binarytree.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	public TreeNode flatten(final TreeNode a) {
		final TreeNode result = new TreeNode(0);
		TreeNode node = result;
		result.right = node;
		if (a == null) {
			return null;
		}

		final Stack<TreeNode> stack = new Stack<>();
		stack.push(a);
		while (!stack.isEmpty()) {
			final TreeNode popped = stack.pop();

			node.right = popped;
			node.left = null;
			node = node.right;

			if (popped.right != null) {
				stack.push(popped.right);
			}
			if (popped.left != null) {
				stack.push(popped.left);
			}
		}
		return result.right;

	}
}
