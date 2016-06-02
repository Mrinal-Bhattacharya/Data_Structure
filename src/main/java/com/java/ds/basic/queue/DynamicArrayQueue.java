package com.java.ds.basic.queue;

public class DynamicArrayQueue {
	private int[] queue;
	private int size;
	private int front;
	private int rear;
	public static int CAPACITY = 16;

	public DynamicArrayQueue() {
		this.queue = new int[DynamicArrayQueue.CAPACITY];
		this.size = this.front = 0;
		this.rear = -1;
	}

	// Inserts an element at the rear of the queue. take O(1) time
	public void enQueue(final int data) {
		if (this.size == DynamicArrayQueue.CAPACITY) {
			this.expand();
		}
		this.size++;
		this.queue[++this.rear] = data;

	}

	private void expand() {
		final int length = this.size();
		final int[] newQueue = new int[length << 1];
		for (int i = this.front; i <= this.rear; i++) {
			newQueue[i + this.front] = this.queue[i % DynamicArrayQueue.CAPACITY];
		}
		this.queue = newQueue;
		this.front = 0;
		this.rear = this.size() - 1;
		DynamicArrayQueue.CAPACITY *= 2;
	}

	// Remove an element at the rear of the queue. take O(1) time
	public int deQueue() {
		if (this.size == 0) {
			throw new IllegalStateException("Queue is empty");
		} else {
			this.size--;
			final int data = this.queue[this.front % DynamicArrayQueue.CAPACITY];
			this.queue[this.front] = Integer.MIN_VALUE;
			this.front = (this.front + 1) % DynamicArrayQueue.CAPACITY;
			return data;
		}
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < this.size; i++) {
			result += Integer.toString(this.queue[(this.front + i) % DynamicArrayQueue.CAPACITY]);
			if (i < (this.size - 1)) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}
