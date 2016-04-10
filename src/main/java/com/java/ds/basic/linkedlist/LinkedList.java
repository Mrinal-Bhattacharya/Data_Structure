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
		node.next = this.head;
		this.head = node;
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
		prevNode.next = node;
	}

	/* Appends a new node at the end. */
	public void append(final T data) {
		final Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node last = this.head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
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
		prev.next = next;
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
	}
}
