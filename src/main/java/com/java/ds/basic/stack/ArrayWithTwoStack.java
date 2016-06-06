package com.java.ds.basic.stack;

public class ArrayWithTwoStack {
	private final int[] dataArray;
	private final int size;
	private int topOne;
	private int topTwo;

	public ArrayWithTwoStack(final int size) {
		this.size = size;
		this.dataArray = new int[size];
		this.topOne = -1;
		this.topTwo = size;
	}

	public void push(final int stackId, final int data) throws Exception {
		if (this.topTwo == (this.topOne + 1)) {
			throw new StackOverflowError("Stack is full");
		}
		if (this.isStackOne(stackId)) {
			this.addStackOne(data);
		} else if (this.isStackTwo(stackId)) {
			this.addStackTwo(data);
		}
		return;
	}

	public Integer pop(final int stackId) throws Exception {
		if (this.isStackOne(stackId)) {
			if (this.isStackOneEmpty()) {
				throw new Exception("First Stack is empty");
			}
			final int data = this.dataArray[this.topOne];
			this.dataArray[this.topOne--] = Integer.MIN_VALUE;
			return data;
		}
		if (this.isStackTwo(stackId)) {
			if (this.isStackTwoEmpty()) {
				throw new Exception("Second Stack is empty");
			}
			final int data = this.dataArray[this.topTwo];
			this.dataArray[this.topTwo++] = Integer.MIN_VALUE;
			return data;
		}
		return null;
	}

	public Integer peek(final int stackId) throws Exception {
		if (this.isStackOne(stackId)) {
			if (this.isStackOneEmpty()) {
				throw new Exception("First Stack is empty");
			}
			return this.dataArray[this.topOne];
		}
		if (this.isStackTwo(stackId)) {
			if (this.isStackTwoEmpty()) {
				throw new Exception("Second Stack is empty");
			}
			return this.dataArray[this.topTwo];
		}
		return null;
	}

	private void addStackTwo(final int data) {
		this.dataArray[--this.topTwo] = data;
	}

	private void addStackOne(final int data) {
		this.dataArray[++this.topOne] = data;
	}

	private boolean isStackTwo(final int stackId) {
		return stackId == 2;
	}

	private boolean isStackOne(final int stackId) {
		return stackId == 1;
	}

	private boolean isStackTwoEmpty() {
		return this.topTwo == this.size;
	}

	private boolean isStackOneEmpty() {
		return this.topOne == -1;
	}

}
