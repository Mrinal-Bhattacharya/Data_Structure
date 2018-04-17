package com.java.ds.basic.tree;

public class SiblingBinaryTreeNode {

	private final int data;
	private SiblingBinaryTreeNode left;
	private SiblingBinaryTreeNode right;
	private SiblingBinaryTreeNode nextSibling;// or same level right node

	public SiblingBinaryTreeNode(final int data) {
		this.data = data;
	}

	public SiblingBinaryTreeNode(final int data, final SiblingBinaryTreeNode left, final SiblingBinaryTreeNode right,
			final SiblingBinaryTreeNode nextSibnling) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.nextSibling = nextSibnling;

	}

	public SiblingBinaryTreeNode getLeft() {
		return this.left;
	}

	public void setLeft(final SiblingBinaryTreeNode left) {
		this.left = left;
	}

	public SiblingBinaryTreeNode getRight() {
		return this.right;
	}

	public void setRight(final SiblingBinaryTreeNode right) {
		this.right = right;
	}

	public SiblingBinaryTreeNode getNextSibling() {
		return this.nextSibling;
	}

	public void setNextSibling(final SiblingBinaryTreeNode nextSibling) {
		this.nextSibling = nextSibling;
	}

	public int getData() {
		return this.data;
	}

}
