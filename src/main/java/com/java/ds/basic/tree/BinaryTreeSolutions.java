package com.java.ds.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSolutions {

	// Give an algorithm for finding maximum element in binary tree.
	public int maxInBinaryTree(final BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return maxValue;
		}
		final int leftMax = (this.maxInBinaryTree(root.getLeft()));
		final int rightMax = (this.maxInBinaryTree(root.getRight()));
		if (leftMax > rightMax) {
			maxValue = leftMax;
		} else {
			maxValue = rightMax;
		}
		if (root.getData() > maxValue) {
			maxValue = root.getData();
		}
		return maxValue;
	}

	// Give an algorithm for finding maximum element in binary tree without
	// recursion.
	public int maxInBinaryTreeLevelOrder(final BinaryTreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root == null) {
			return maxValue;
		}
		final BinaryTreeNode node = root;
		final Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			final BinaryTreeNode temp = q.poll();
			if (temp.getData() > maxValue) {
				maxValue = temp.getData();
			}
			if (temp.getLeft() != null) {
				q.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.offer(temp.getRight());
			}
		}
		return maxValue;
	}

	// Given an algorithm for searching an element in binary tree.
	public boolean findInBT(final BinaryTreeNode root, final int data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			return true;
		}
		return this.findInBT(root.getLeft(), data) || this.findInBT(root.getRight(), data);
	}
}
