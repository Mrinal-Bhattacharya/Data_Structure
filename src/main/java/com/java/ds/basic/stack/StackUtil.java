package com.java.ds.basic.stack;

import java.util.Stack;

public class StackUtil {

	/*
	 * Given an array of characters formed with a's and b's. The string is marked
	 * with special character X which means represents the middle of the list(for
	 * example ababXbaba). Check string is palindrome.
	 */
	public boolean isPalindrome(final String inputStr) {
        final char[] inputChar = inputStr.toCharArray();
		final Stack<Character> stack = new Stack<>();
		int i = 0;
		while (inputChar[i] != 'X') {
			stack.push(inputChar[i]);
			i++;
		}
		i++;
		while (i < inputChar.length) {
			if (stack.isEmpty()) {
				return false;
			}
			if (inputChar[i] != stack.pop()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Given a stack how to reverse the contents of stacks using only stack
	 * operations(push and pop)?
	 */
	public void reverseStack(final Stack stack) {
		if (stack.isEmpty()) {
			return;
		}
		final Object temp = stack.pop();
		this.reverseStack(stack);
		this.insertAtBottom(stack, temp);
	}

	private void insertAtBottom(final Stack stack, final Object data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		final Object temp = stack.pop();
		this.insertAtBottom(stack, data);
		stack.push(temp);
	}

	public static void main(final String[] args) {

	}
}
