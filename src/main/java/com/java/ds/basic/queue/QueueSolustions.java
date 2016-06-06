package com.java.ds.basic.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSolustions {

	// Give an algorithm for reversing a queue Q. To access the queue, you are
	// only allowed to use the methods of queue ADT.
	public static void reverseQueue(final Queue<Integer> queue) {
		final Stack<Integer> stack = new Stack<Integer>();
		QueueSolustions.transferDataFromQueueToStack(queue, stack);
		QueueSolustions.transferDataFromStackToQueue(stack, queue);
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

	private static void transferDataFromStackToQueue(final Stack<Integer> stack, final Queue<Integer> queue) {
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}

	private static void transferDataFromQueueToStack(final Queue<Integer> queue, final Stack<Integer> stack) {
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
	}

	public static Stack<Integer> transfer(final Queue<Integer> queue) {
		final Stack<Integer> stack = new Stack<Integer>();
		QueueSolustions.transferDataFromQueueToStack(queue, stack);
		QueueSolustions.transferDataFromStackToQueue(stack, queue);
		QueueSolustions.transferDataFromQueueToStack(queue, stack);
		return stack;
	}

	/*
	 * Given a stack of integers, how do check whether each successive pair of
	 * numbers in the stack is consecutive or not. The pairs can be increasing
	 * or decreasing, and if the stack has an odd number of elements the element
	 * at the top is left out of a pair. For example if the stack of elements
	 * are [4,5,-2,-3,11,10,5,6,20], then the output should be true because each
	 * of the pairs (4,5),(-2,-3), (11,10) and (5,6) consists of consecutive
	 * numbers.
	 */
	public static boolean checkStackPairWiseOrder(final Stack<Integer> s) {
		final Queue<Integer> q = new LinkedList<Integer>();
		boolean pairWiseOrdered = true;
		QueueSolustions.transferDataFromStackToQueue(s, q);
		QueueSolustions.transferDataFromQueueToStack(q, s);
		while (!s.empty()) {
			final int n = s.pop();
			q.offer(n);
			if (!s.empty()) {
				final int m = s.pop();
				q.offer(m);
				if (Math.abs(n - m) != 1) {
					pairWiseOrdered = false;
				}
			}
		}
		while (!q.isEmpty()) {
			s.push(q.remove());
		}
		return pairWiseOrdered;
	}

	/*
	 * Given a queue of integers, rearrange the elements by interleaving the
	 * first half of the list with the second half of the list. For example,
	 * suppose a queue stores the following sequence of
	 * values:[11,12,13,14,15,16,17,18,19,20]. Consider the two halves of the
	 * list: first half: [11,12,13,14,15] second half: [16,17,18,19,20]. These
	 * are combined in an altering fashion to form a sequence of interleave
	 * pairs: the first values from each half(11 and 16), then the second values
	 * from each half (12 and 17), then the third values from each half(13 and
	 * 18), and so on. In each pair, the value from the first half appears
	 * before the value from the second half. Thus after the call, the queue
	 * stores the following values:[11,16,12,17,13,18,14,19,15,20].
	 */

	public void interLeavingQueue(final Queue<Integer> q) {
		if ((q.size() % 2) != 0) {
			throw new IllegalArgumentException();
		}
		final Stack<Integer> s = new Stack<Integer>();
		final int halfSize = q.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			s.push(q.poll());
		}
		while (!s.isEmpty()) {
			q.offer(s.pop());
			for (int i = 0; i < halfSize; i++) {
				q.offer(q.poll());
			}
		}
		for (int i = 0; i < halfSize; i++) {
			s.push(q.poll());
		}
		while (!s.isEmpty()) {
			q.offer(s.pop());
			q.offer(q.poll());
		}
	}

	/*
	 * Given an integer k and a queue of integers, how do you reverse the order
	 * of the first k elements of the queue, leaving the other elements in the
	 * same relative order? For example, if k=4 and queue has the elements
	 * [10,20,30,40,50,60,70,80,90]; the output should be
	 * [40,30,20,10,50,60,70,80,90].
	 */
	public static void reverseQueueFirstKElements(final int k, final Queue<Integer> q) {
		if ((q == null) || (k > q.size())) {
			throw new IllegalArgumentException();
		} else if (k > 0) {
			final Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < k; i++) {
				s.push(q.remove());
			}
			QueueSolustions.transferDataFromStackToQueue(s, q);
			for (int i = 0; i < (q.size() - k); i++) {
				q.add(q.remove());
			}
		}
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
