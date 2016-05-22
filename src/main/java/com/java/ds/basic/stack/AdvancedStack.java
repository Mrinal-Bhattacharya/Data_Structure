package com.java.ds.basic.stack;

public class AdvancedStack {
	private final LinkedStack elementStack = new LinkedStack();
	private final LinkedStack minStack = new LinkedStack();

	public void push(final int data) throws Exception {
		this.elementStack.push(data);
		if (this.minStack.isEmpty() || (this.minStack.peek() >= data)) {
			this.minStack.push(data);
		} else {
			this.minStack.push(this.minStack.peek());
		}
	}

	public Integer pop() throws Exception {
		if (this.elementStack.isEmpty()) {
			return null;
		}
		this.minStack.pop();
		return this.elementStack.pop();
	}

	public int getMinimum() throws Exception {
		return this.minStack.peek();
	}
}
