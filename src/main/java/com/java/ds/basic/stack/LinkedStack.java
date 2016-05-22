package com.java.ds.basic.stack;

public class LinkedStack {
	private int length = 0;
	private ListNode top;

	public void push(final int data) {
		final ListNode temp = new ListNode(data);
		temp.setNext(this.top);
		this.top = temp;
		this.length++;
	}

	public int pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		final int result = this.top.getData();
		this.top = this.top.getNext();
		this.length--;
		return result;
	}

	public int peek() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		final int result = this.top.getData();
		return result;
	}

	public boolean isEmpty() {
		return (this.length == 0);
	}

	@Override
	public String toString() {
		String result = "";
		ListNode current = this.top;
		while (current != null) {
			result += current.toString() + "\n";
			current = current.next;
		}
		return result;
	}

	static class ListNode {
		private final int data;
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

		public void setNext(final ListNode next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}
	}
}
