package com.java.ds.basic.stack;

import java.util.Stack;

public class InfixToPostfix {
	private final String infix;

	public InfixToPostfix(final String infix) {
		this.infix = infix;
	}

	String convert() {
		String result = "";
		final Stack<Character> stack = new Stack<Character>();
		char symbol;
		for (int i = 0; i < this.infix.length(); i++) {
			symbol = this.infix.charAt(i);
			if (Character.isLetter(symbol)) {
				result += symbol;
			} else if (symbol == '(') {
				stack.push(symbol);
			} else if (symbol == ')') {
				while (stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && !(stack.peek() == '(') && (this.prec(symbol) <= this.prec(stack.peek()))) {
					result += stack.pop();
				}
				stack.push(symbol);
			}

		}
		return result;
	}

	private int prec(final char symbol) {
		if ((symbol == '+') || (symbol == '-')) {
			return 1;
		}
		if ((symbol == '*') || (symbol == '/') || (symbol == '%')) {
			return 2;
		}
		return 0;
	}
}
