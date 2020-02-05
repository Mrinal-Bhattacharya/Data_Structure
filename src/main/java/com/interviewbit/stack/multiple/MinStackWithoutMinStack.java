package com.interviewbit.stack.multiple;

import java.util.Stack;

public class MinStackWithoutMinStack {

	Stack<Integer> stack = new Stack<>();

	public MinStackWithoutMinStack() {
		this.stack = new Stack<>();
	}


    Stack<Integer> s = new Stack<>();
    Integer minEle;

	// Prints minimum element of MyStack
	void getMin2() {
		// Get the minimum number in the entire stack
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			System.out.println("Minimum Element in the " + " stack is: " + this.minEle);
		}
	}

	// prints top element of MyStack
	void peek() {
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}

		final Integer t = this.s.peek(); // Top element.
		System.out.print("Top Most Element is: ");
		// If t < minEle means minEle stores value of t.
		if (t < this.minEle) {
			System.out.println(this.minEle);
		} else {
			System.out.println(t);
		}
	}

	// Removes the top element from MyStack (2*minEle � y)
	void pop() {
		if (this.s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Top Most Element Removed: ");
		final Integer t = this.s.pop();

		// Minimum will change as the minimum element of the stack is being removed.
		if (t < this.minEle) {
			System.out.println(this.minEle);
			this.minEle = (2 * this.minEle) - t;
		} else {
			System.out.println(t);
		}
	}

	// Insert new number into MyStack
	void push(final Integer x) {
		if (this.s.isEmpty()) {
			this.minEle = x;
			this.s.push(x);
			System.out.println("Number Inserted: " + x);
			return;
		}

		// If new number is less than original minEle (2*x � minEle)
		if (x < this.minEle) {
			this.s.push((2 * x) - this.minEle);
			this.minEle = x;
		} else {
			this.s.push(x);
		}

		System.out.println("Number Inserted: " + x);
	}
}
