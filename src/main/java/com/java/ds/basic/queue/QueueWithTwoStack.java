package com.java.ds.basic.queue;

import java.util.Stack;

//How can you implement queue in two stack
public class QueueWithTwoStack<T> {
	Stack<T> stack1 = new Stack<T>();
	Stack<T> stack2 = new Stack<T>();

	public void enQueue(final T data) {
		this.stack1.push(data);
	}

	public T deQueue() {
		if (this.stack2.isEmpty()) {
			while (!this.stack1.isEmpty()) {
				this.stack2.push(this.stack1.pop());
			}
			return this.stack2.pop();
		} else {
			return this.stack2.pop();
		}
	}
}
