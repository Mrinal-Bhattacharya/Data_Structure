package com.java.ds.basic.queue;

public class LinkedQueue {

	private int length;
	private ListNode front;
	private ListNode rear;

	public LinkedQueue() {
		this.length = 0;
		this.front = this.rear = null;
	}

	public void enQueue(final int data) {
		final ListNode node = new ListNode(data);
		if (this.isEmpty()) {
			this.front = node;
		} else {
			this.rear.setNext(node);
		}
		this.rear = node;
		this.length++;
	}

	public int deQueue() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		final int result = this.front.getData();
		this.front = this.front.getNext();
		this.length--;
		if (this.isEmpty()) {
			this.rear = null;
		}
		return result;
	}

	// Return data from front but it will not remove data from queue
	public int first() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return this.front.getData();
	}

	private boolean isEmpty() {
		return this.length == 0;
	}

	public int size() {
		return this.length;
	}

	@Override
	public String toString() {
		String result = "";
		ListNode current = this.front;
		while (current != null) {
			result = result + current.toString() + "\n";
			current = current.getNext();
		}

		return result;
	}

	private static class ListNode {
		int data;
		private ListNode next;

		public ListNode(final int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return this.next;
		}

		public int getData() {
			return this.data;
		}

		public void setNext(final ListNode node) {
			this.next = node;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}
	}
}
