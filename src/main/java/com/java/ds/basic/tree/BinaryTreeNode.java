package com.java.ds.basic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

	public List<Integer> inOrderTraversal(final BinaryTreeNode root) {

		BinaryTreeNode node = root;
		final List<Integer> result = new ArrayList<Integer>();
		if (node == null) {
			return result;
		}
		final Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while (!s.isEmpty() || (node != null)) {

			if (node != null) {
				s.push(node);
				node = node.getLeft();
			} else {
				node = s.pop();
				result.add(node.getData());
				node = node.getRight();
			}
		}
		return result;
	}

	public void postOrder(final BinaryTreeNode root) {
		if (root != null) {
			this.postOrder(root.right);
			this.postOrder(root.left);
			System.out.println(root.getData());
		}
	}

	public List<Integer> postOrderTraversal(final BinaryTreeNode root) {

		final BinaryTreeNode node = root;
		final List<Integer> result = new ArrayList<Integer>();
		if (node == null) {
			return result;
		}
		final Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
		final Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
		s1.push(node);
		while (!s1.isEmpty()) {
			final BinaryTreeNode popNode = s1.pop();
			s2.push(popNode);

			if (popNode.left != null) {
				s1.push(node.left);
			}
			if (popNode.right != null) {
				s1.push(node.right);
			}
		}
		while (!s2.isEmpty()) {
			result.add(s2.pop().getData());
		}
		return result;
	}

	public List<Integer> levelOrder(final BinaryTreeNode root) {
		final BinaryTreeNode node = root;
		final List<Integer> result = new ArrayList<Integer>();
		if (node == null) {
			return result;
		}
		final Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			final BinaryTreeNode pollNode = q.poll();
			result.add(pollNode.getData());
			if (pollNode.left != null) {
				q.offer(pollNode.left);
			}
			if (pollNode.right != null) {
				q.offer(pollNode.right);
			}
		}
		return result;
	}
}
