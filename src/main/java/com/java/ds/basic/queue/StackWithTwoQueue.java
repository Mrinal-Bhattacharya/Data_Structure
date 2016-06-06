package com.java.ds.basic.queue;

import java.util.LinkedList;
import java.util.Queue;

//Show how can you efficiently implement one stack using two queues. Analyze the running time of the stack
public class StackWithTwoQueue<T> {
	private final Queue<T> Q1 = new LinkedList<T>();
	private final Queue<T> Q2 = new LinkedList<T>();

	public void push(final T data) {
		if (this.Q1.isEmpty()) {
			this.Q2.offer(data);
		} else {
			this.Q1.offer(data);
		}
	}

	// O(n) as each time pop is called, we are transferring all the elements
	// from
	// one queue to the other.
	// return it.
	public T pop() {
		int i = 0, size;
		if (this.Q2.isEmpty()) {
			size = this.Q1.size();
			while (i < (size - 1)) {
				this.Q2.offer(this.Q1.poll());
				i++;
			}
			return this.Q1.poll();
		} else {
			size = this.Q2.size();
			while (i < (size - 1)) {
				this.Q1.offer(this.Q2.poll());
				i++;
			}
			return this.Q2.poll();
		}
	}
}
