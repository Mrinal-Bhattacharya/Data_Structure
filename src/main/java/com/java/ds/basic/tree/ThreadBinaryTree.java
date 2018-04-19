package com.java.ds.basic.tree;

public class ThreadBinaryTree {
	private int data;
	private ThreadBinaryTree left;
	private ThreadBinaryTree right;
	private boolean lThread;
	private boolean rThread;

	public ThreadBinaryTree(final int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.lThread = true;
		this.rThread = true;
	}

	public int getData() {
		return this.data;
	}

	public void setData(final int data) {
		this.data = data;
	}

	public ThreadBinaryTree getLeft() {
		return this.left;
	}

	public void setLeft(final ThreadBinaryTree left) {
		this.left = left;
	}

	public ThreadBinaryTree getRight() {
		return this.right;
	}

	public void setRight(final ThreadBinaryTree right) {
		this.right = right;
	}

	public boolean islThread() {
		return this.lThread;
	}

	public boolean isrThread() {
		return this.rThread;
	}

	public void setlThread(final boolean lThread) {
		this.lThread = lThread;
	}

	public void setrThread(final boolean rThread) {
		this.rThread = rThread;
	}

	@Override
	public String toString() {
		return "ThreadBinaryTree [data=" + this.data + "]";
	}

}
