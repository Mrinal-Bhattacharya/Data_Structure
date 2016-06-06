package com.java.ds.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(final int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return this.data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return this.left;
	}

	public void setLeft(final BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return this.right;
	}

	public void setRight(final BinaryTreeNode right) {
		this.right = right;
	}

	public void preOrder(final BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			this.preOrder(root.left);
			this.preOrder(root.right);
		}
	}

	public List<Integer> preOrderTraversal(final BinaryTreeNode root) {
		final List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		final Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			final BinaryTreeNode temp = s.pop();
			result.add(temp.getData());
			if (temp.getRight() != null) {
				s.push(temp.getRight());
			}
			if (temp.getLeft() != null) {
				s.push(temp.getLeft());
			}
		}
		return result;
	}

	public void inOrder(final BinaryTreeNode root) {
		if (root != null) {
			this.inOrder(root.left);
			System.out.println(root.getData());
			this.inOrder(root.right);
		}
	}

	public void postOrder(final BinaryTreeNode root) {
		if (root != null) {
			this.postOrder(root.right);
			this.postOrder(root.left);
			System.out.println(root.getData());
		}
	}
}
