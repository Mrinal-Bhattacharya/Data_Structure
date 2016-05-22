package com.java.ds.basic.stack;

public class AdvancedStackWithImproveSpaceComplexity {
	private final LinkedStack elementStack = new LinkedStack();
	private final LinkedStack minStack = new LinkedStack();

	public void push(final int data) throws Exception {
		this.elementStack.push(data);
		if (this.minStack.isEmpty() || (this.minStack.peek() >= data)) {
			this.minStack.push(data);
		}
	}

	public Integer pop() throws Exception {
		if (this.elementStack.isEmpty()) {
			return null;
		}
		final int minTop = this.minStack.peek();
		final int elementTop = this.elementStack.peek();
		if (minTop == elementTop) {
			this.minStack.pop();
		}
		return this.elementStack.pop();
	}

	public int getMinimum() throws Exception {
		return this.minStack.peek();
	}
}
