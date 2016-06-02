package com.java.ds.basic.queue;

public class FixedSizeArrayQueue {
	private final int[] queueRep;
	private int size;
	private int front;
	private int rear;
	private static final int CAPACITY = 16;

	public FixedSizeArrayQueue() {
		this.queueRep = new int[FixedSizeArrayQueue.CAPACITY];
		this.size = this.front = this.rear = 0;
	}

	// Inserts an element at the rear of the queue. take O(1) time
	public void enQueue(final int data) {
		if (this.size == FixedSizeArrayQueue.CAPACITY) {
			throw new IllegalStateException("Queue is full");
		} else {
			this.size++;
			this.queueRep[this.rear] = data;
			this.rear = (this.rear + 1) % FixedSizeArrayQueue.CAPACITY;
		}
	}

	// Remove an element at the rear of the queue. take O(1) time
	public int deQueue() {
		if (this.size == 0) {
			throw new IllegalStateException("Queue is empty");
		} else {
			this.size--;
			final int data = this.queueRep[this.front % FixedSizeArrayQueue.CAPACITY];
			this.queueRep[this.front] = Integer.MIN_VALUE;
			this.front = (this.front + 1) % FixedSizeArrayQueue.CAPACITY;
			return data;
		}
	}

	// Check whether the queue is empty.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Check whether the queue is full.
	public boolean isFull() {
		return this.size == FixedSizeArrayQueue.CAPACITY;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < this.size; i++) {
			result += Integer.toString(this.queueRep[(this.front + i) % FixedSizeArrayQueue.CAPACITY]);
			if (i < (this.size - 1)) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}
