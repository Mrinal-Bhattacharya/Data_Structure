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
		if (stackId == 1) {
			this.dataArray[++this.topOne] = data;
		} else if (stackId == 2) {
			this.dataArray[--this.topTwo] = data;
		}
		return;
	}

	public Integer pop(final int stackId) throws Exception {
		if (stackId == 1) {
			if (this.topOne == -1) {
				throw new Exception("First Stack is empty");
			}
			final int data = this.dataArray[this.topOne];
			this.dataArray[this.topOne--] = Integer.MIN_VALUE;
			return data;
		}
		if (stackId == 2) {
			if (this.topTwo == this.size) {
				throw new Exception("Second Stack is empty");
			}
			final int data = this.dataArray[this.topTwo];
			this.dataArray[this.topTwo++] = Integer.MIN_VALUE;
			return data;
		}
		return null;
	}

	public Integer peek(final int stackId) throws Exception {
		if (stackId == 1) {
			if (this.topOne == -1) {
				throw new Exception("First Stack is empty");
			}
			return this.dataArray[this.topOne];
		}
		if (stackId == 2) {
			if (this.topTwo == this.size) {
				throw new Exception("Second Stack is empty");
			}
			return this.dataArray[this.topTwo];
		}
		return null;
	}

}
