package com.java.ds.basic.tree;

public class ThreadBinarySolutions {
	public static void main(final String[] args) {
		ThreadBinaryTree root = null;
		root = ThreadBinarySolutions.insert(root, 20);
		root = ThreadBinarySolutions.insert(root, 10);
		root = ThreadBinarySolutions.insert(root, 30);
		final ThreadBinaryTree node10 = ThreadBinarySolutions.findInBT(root, 10);
		System.out.println(node10.getRight());

	}

	private static ThreadBinaryTree insert(final ThreadBinaryTree root, final int i) {
		final ThreadBinaryTree tmp = new ThreadBinaryTree(i);
		if (root == null) {
			return tmp;
		}
		ThreadBinaryTree current = root;
		ThreadBinaryTree parent = null;
		while (current != null) {
			parent = current;
			if (tmp.getData() < current.getData()) {
				if (current.islThread() == false) {
					current = current.getLeft();
				} else {
					break;
				}
			} else {
				if (current.isrThread() == false) {
					current = current.getRight();
				} else {
					break;
				}
			}
		}
		if (tmp.getData() < parent.getData()) {
			tmp.setLeft(parent.getLeft());
			tmp.setRight(parent);
			parent.setlThread(false);
			parent.setLeft(tmp);

		} else {
			tmp.setLeft(parent);
			tmp.setRight(parent.getRight());
			parent.setrThread(false);
			parent.setRight(tmp);
		}
		return root;
	}

	public static ThreadBinaryTree findInBT(final ThreadBinaryTree root, final int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() == data) {
			return root;
		}
		if (data < root.getData()) {
			return ThreadBinarySolutions.findInBT(root.getLeft(), data);
		} else {
			return ThreadBinarySolutions.findInBT(root.getRight(), data);
		}
	}
}
