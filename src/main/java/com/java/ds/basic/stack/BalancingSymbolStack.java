package com.java.ds.basic.stack;

import java.util.Stack;

public class BalancingSymbolStack {
	public boolean isValidSymbolPattern(final String s) {
		final Stack<Character> stack = new Stack<Character>();
		if ((s == null) || (s.length() <= 0)) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (stack.isEmpty() && (stack.peek() == '(')) {
					stack.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty() && (stack.peek() == '{')) {
					stack.pop();
				} else {
					return false;
				}
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty() && (stack.peek() == '[')) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				stack.push(s.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
