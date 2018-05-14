package com.java.ds.basic.stack;

import java.util.Stack;

public class StackWithMinAndMax {
	Stack<Integer> s;
	Integer minEle;
	private Integer maxEle;

	// Constructor
	StackWithMinAndMax() {
		this.s = new Stack<>();
	}

	// Prints minimum element of MyStack
	void getMin() {
		// Get the minimum number in the entire stack
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Minimum Element in the " + " stack is: " + this.minEle);
		}
	}

	// Prints minimum element of MyStack
	void getMax() {
		// Get the minimum number in the entire stack
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Max Element in the " + " stack is: " + this.maxEle);
		}
	}

	// Removes the top element from MyStack
	void pop() {
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		final Integer t = this.s.pop();

		// Minimum will change as the minimum element
		// of the stack is being removed.
		if (t < this.minEle) {
			System.out.println(this.minEle);
			this.minEle = (2 * this.minEle) - t;
		} else if (t > this.maxEle) {
			System.out.println(this.maxEle);
			this.maxEle = (2 * this.maxEle) - t;
		} else {
			System.out.println(t);
		}
	}

	// Insert new number into MyStack
	void push(final Integer x) {
		if (this.s.isEmpty()) {
			this.minEle = x;
			this.maxEle = x;
			this.s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle
		if (x < this.minEle) {
			this.s.push((2 * x) - this.minEle);
			this.minEle = x;
		} else if (x > this.maxEle) {
			this.s.push((2 * x) - this.maxEle);
			this.maxEle = x;
		} else {
			this.s.push(x);
		}

		System.out.println("Number Inserted: " + x);
	}

	public static void main(final String[] args) {
		final StackWithMinAndMax minAndMax = new StackWithMinAndMax();
		minAndMax.push(5);
		minAndMax.getMin();
		minAndMax.getMax();
		minAndMax.push(2);
		minAndMax.getMin();
		minAndMax.getMax();
		minAndMax.push(4);
		minAndMax.getMin();
		minAndMax.getMax();
		minAndMax.push(7);
		minAndMax.getMin();
		minAndMax.getMax();
		minAndMax.push(1);
		minAndMax.getMin();
		minAndMax.getMax();
		System.out.println("Remove start>>>>>>>>>>>>>>>>>>>");
		minAndMax.pop();
		minAndMax.getMin();
		minAndMax.getMax();
		minAndMax.pop();
		minAndMax.getMin();
		minAndMax.getMax();
	}
}
