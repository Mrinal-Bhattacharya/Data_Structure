package com.java.ds.basic.stack;

public class FixedSizedArrayStack {
	private final int capacity;
	private static final int CAPACITY = 10;
	private final int[] stackArr;
	private int top = -1;

	public FixedSizedArrayStack() {
		this(FixedSizedArrayStack.CAPACITY);
	}

	public FixedSizedArrayStack(final int capacity) {
		this.capacity = capacity;
		this.stackArr = new int[FixedSizedArrayStack.CAPACITY];
	}

	public int size() {
		return (this.top + 1);
	}

	public boolean isEmpty() {
		return (this.top < 0);
	}

	public void push(final int data) throws Exception {
		if (this.size() == this.capacity) {
			throw new Exception("Stack is full");
		}
		this.stackArr[++this.top] = data;
	}

	public int top() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return this.stackArr[this.top];
	}

	public int pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}

		final int data = this.stackArr[this.top];
		this.stackArr[this.top--] = Integer.MIN_VALUE;
		return data;
	}

	@Override
	public String toString() {
		String s;
		s = "[";
		if (this.size() > 0) {
			s += this.stackArr[0];
		}
		if (this.size() > 1) {
			for (int i = 1; i < this.stackArr.length; i++) {
				s += ", " + this.stackArr[i];
			}
		}
		return s + "]";
	}
}
