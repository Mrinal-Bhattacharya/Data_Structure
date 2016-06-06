package com.java.ds.basic.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSolustions {

	// Give an algorithm for reversing a queue Q. To access the queue, you are
	// only allowed to use the methods of queue ADT.
	public static void reverseQueue(final Queue<Integer> queue) {
		final Stack<Integer> stack = new Stack<Integer>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}
	/*
	 * A queue Q containing n items and an empty stack S are given. It is
	 * required to transfer all the items from the queue to the stack, so that
	 * the item at the front of the queue is on the top of the stack, and the
	 * order of all the other items is preserved. Show this how this can be done
	 * in O(n) time using only a constant amount of additional storage. Note
	 * that the only operations which can be performed on the queue and stack
	 * are Delete, Insert, Push and Pop. Do not assume any implementation of the
	 * queue or stack.
	 */

	public static Stack<Integer> transfer(final Queue<Integer> queue) {
		final Stack<Integer> stack = new Stack<Integer>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		return stack;
	}

	public static void main(final String[] args) {
		final Queue<Integer> integers = new LinkedList<Integer>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		System.out.println(integers);
		final Stack<Integer> transfer = QueueSolustions.transfer(integers);
		System.out.println(transfer);
		// System.out.println(transfer.pop());

	}
}
