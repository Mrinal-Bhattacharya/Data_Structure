//****************************************************************
//* Copyright (c) 2016 Ford Motor Company. All Rights Reserved.
//****************************************************************
package com.java.ds.basic.linkedlist;

/**
 * TODO - Place class description here
 */
public class NonGenericLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(final int d) {
			this.data = d;
			this.next = null;
		}
	}

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void push(final int new_data) {
		final Node node = new Node(new_data);
		node.next = this.head;
		this.head = node;
	}

	/*
	 * Takes two lists sorted in increasing order, and splices their nodes together
	 * to make one big sorted list which is returned.
	 */
	public Node sortedMerge(Node a, Node b) {
		Node tail = new Node(-1);
		final Node dummy = tail;
		while (true) {
			if (a == null) {
				tail.next = b;
				break;
			}
			if (b == null) {
				tail.next = a;
				break;
			}
			if (a.data <= b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		return dummy.next;
	}

	public void printLinkedList(final Node node) {
		Node n = node;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	Node reverse(final Node head) {
		Node prev = null;
		Node current = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	// Function that detects loop in the list
	public void detectAndRemoveLoop(final Node node) {
		Node slow = node;
		Node fast = node.next;

		// Search for loop using slow and fast pointers
		// 1-->2-->3-->4-->5-->2
		// So it will just check for loop so slow and fast node can be different
		// from loop
		// point as slow=4 and
		// fast=4
		while ((fast != null) && (fast.next != null)) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		/* If loop exists */
		if (slow == fast) {
			slow = node;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */

		}
	}

	public static void main(final String[] args) {
		final NonGenericLinkedList nonGenericLinkedList = new NonGenericLinkedList();
		final NonGenericLinkedList a = new NonGenericLinkedList();
		final NonGenericLinkedList b = new NonGenericLinkedList();
		a.push(15);
		a.push(10);
		a.push(5);

		b.push(20);
		b.push(3);
		b.push(2);

		final NonGenericLinkedList.Node merge = nonGenericLinkedList.sortedMerge(a.head, b.head);
		nonGenericLinkedList.printLinkedList(merge);

		final NonGenericLinkedList list = new NonGenericLinkedList();
		list.head = list.new Node(1);
		list.head.next = list.new Node(2);
		list.head.next.next = list.new Node(3);
		list.head.next.next.next = list.new Node(4);
		list.head.next.next.next.next = list.new Node(5);

		// Creating a loop for testing
		list.head.next.next.next.next.next = list.head.next;
		list.detectAndRemoveLoop(list.head);
		System.out.println("Linked List after removing loop : ");
		list.printLinkedList(list.head);

		final int x = 23 % 10;
		System.out.println(">>>>>>>>>>>>>>. " + x);
	}

}
