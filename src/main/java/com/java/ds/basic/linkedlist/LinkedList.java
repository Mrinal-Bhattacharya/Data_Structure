//****************************************************************
//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.
//****************************************************************
package com.java.ds.basic.linkedlist;

public class LinkedList<T> {
	Node head;

	class Node {
		T data;
		Node next;

		public Node(final T data) {
			this.data = data;
		}
	}

	public void printLinkedList() {
		Node n = this.head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void push(final T new_data) {
		final Node node = new Node(new_data);
		pointNewNodeNextToHead(node);
		pointHeadToNewNode(node);
	}

	private void pointHeadToNewNode(final Node node) {
		this.head = node;
	}

	private void pointNewNodeNextToHead(final Node node) {
		node.next = this.head;
	}

	/*
	 * Given a node prev_node, insert a new node after the given prev_node
	 */
	public void insertAfter(final Node prevNode, final T data) {
		if (prevNode == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		final Node node = new Node(data);
		node.next = prevNode.next;
		pointNodeNextToNewNode(prevNode, node);
	}

	/* Appends a new node at the end. */
	public void append(final T data) {
		final Node node = new Node(data);
		if (this.head == null) {
			pointHeadToNewNode(node);
			return;
		}
		Node last = getLastNode();
		pointNodeNextToNewNode(last, node);
	}

	private void pointNodeNextToNewNode(Node last, final Node node) {
		last.next = node;
	}

	private Node getLastNode() {
		Node last = this.head;
		while (last.next != null) {
			last = last.next;
		}
		return last;
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	public void deleteNode(final T key) {
		if (key == null) {
			return;
		}
		Node temp = this.head;
		Node prev = null;
		while ((temp != null) && (temp.data != key)) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			return;
		}
		prev.next = temp.next;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a
	 * position, deletes the node at the given position
	 */
	public void deleteNode(final int position) {
		if (this.head == null) {
			return;
		}
		if (position == 0) {
			this.head = this.head.next;
		}
		Node prev = this.head;
		for (int i = 0; (i < (position - 1)) && (prev != null); i++) {
			prev = prev.next;
		}
		if ((prev == null) || (prev.next == null)) {
			return;
		}
		final Node next = prev.next.next;
		pointNodeNextToNewNode(prev, next);
	}

	/* Returns count of nodes in linked list */
	public int getCount() {
		int count = 0;
		Node current = this.head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void swap(final T x, final T y) {
		if (x == y) {
			return;
		}
		Node currX = this.head, prevX = null;

		while ((currX != null) && (currX.data != x)) {
			prevX = currX;
			currX = currX.next;
		}
		Node currY = this.head, prevY = null;
		while ((currY != null) && (currY.data != x)) {
			prevY = currY;
			currY = currY.next;
		}
		if ((currX == null) || (currY == null)) {
			return;
		}
		if (prevX != null) {
			pointNodeNextToNewNode(prevX, currY);
		} else {
			pointHeadToNewNode(currY);
		}
		if (prevY != null) {
			pointNodeNextToNewNode(prevY, currX);
		} else {
			pointHeadToNewNode(currX);
		}
		final Node temp = currX.next;
		currX.next = currY.next;
		pointNodeNextToNewNode(currY, temp);

	}

	/*
	 * Function to reverse the linked list. Iterate trough the linked list. In
	 * loop, change next to prev, prev to current and current to next.
	 */
	public void reverse() {
		Node current = this.head, prev = null, next = null;
		while (current != null) {
			next = current.next;
			pointNodeNextToNewNode(current, prev);
			prev = current;
			current = next;
		}
		pointHeadToNewNode(prev);
	}

	public static void main(final String[] args) {
		final LinkedList<Integer> llist = new LinkedList<Integer>();
		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printLinkedList();
		System.out.println("After reverse ");
		llist.reverse();
		llist.printLinkedList();
	}
}
