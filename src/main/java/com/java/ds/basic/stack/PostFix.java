package com.java.ds.basic.stack;

import java.util.Stack;

public class PostFix {
	private final String postfix;

	public PostFix(final String postfix) {
		this.postfix = postfix;
	}

	public int calculation() {
		final Stack<Integer> integers = new Stack<Integer>();
		for (int i = 0; i < this.postfix.length(); i++) {
			if (this.postfix.charAt(i) == '+') {
				final int op1 = integers.pop();
				final int op2 = integers.pop();
				final int result = op1 + op2;
				integers.push(result);
			} else if (this.postfix.charAt(i) == '-') {
				final int op1 = integers.pop();
				final int op2 = integers.pop();
				final int result = op1 - op2;
				integers.push(result);
			} else if (this.postfix.charAt(i) == '*') {
				final int op1 = integers.pop();
				final int op2 = integers.pop();
				final int result = op1 * op2;
				integers.push(result);
			} else if (this.postfix.charAt(i) == '/') {
				final int op1 = integers.pop();
				final int op2 = integers.pop();
				final int result = op1 / op2;
				integers.push(result);
			} else {
				integers.push(Integer.valueOf(this.postfix.charAt(i)));
			}
		}
		return integers.pop();
	}
}
