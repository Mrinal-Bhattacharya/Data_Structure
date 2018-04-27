package com.java.ds.basic.tree;

public class ThreadBinarySolutions {

	public ThreadBinaryTree insert(final ThreadBinaryTree root, final int i) {
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
				if (current.isRThread() == false) {
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

	public ThreadBinaryTree findInBT(final ThreadBinaryTree root, final int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() == data) {
			return root;
		}
		if (data < root.getData()) {
			return this.findInBT(root.getLeft(), data);
		} else {
			return this.findInBT(root.getRight(), data);
		}
	}

	public ThreadBinaryTree inOrderSuccessor(final ThreadBinaryTree node) {
		ThreadBinaryTree position;
		if (node.isRThread() == false) {
			return node.getRight();
		} else {
			position = node.getRight();
			while ((position != null) && position.islThread()) {
				position = position.getLeft();
			}
			return position;
		}
	}

	public void inOrderTraversal(final ThreadBinaryTree root) {
		ThreadBinaryTree curr = this.findLeftMost(root);
		while (curr != null) {
			System.out.println(curr.getData());
			curr = curr.getRight();
		}

	}

	private ThreadBinaryTree findLeftMost(ThreadBinaryTree node) {
		if (node == null) {
			return null;
		}
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}
}
