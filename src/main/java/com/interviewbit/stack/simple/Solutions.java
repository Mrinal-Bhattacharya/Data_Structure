package com.interviewbit.stack.simple;

import java.util.Stack;

public class Solutions {
	public String simplifyPath(final String A) {
		final Stack<String> stack = new Stack<>();
		final String[] args = A.trim().split("/");
		for (final String s : args) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!s.isEmpty() && !s.equals(".")) {
				stack.push(s);
			}
		}

        final StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}

		return sb.length() != 0 ? sb.toString() : "/";
	}

	public int braces(final String A) {
		final Stack<Character> stack = new Stack<>();
		for (final char c : A.toCharArray()) {
			if (c == ')') {
				char top = stack.pop();
				if (top == '(') {
					return 1;
				} else {
					int count = 0;
					while (top != '(') {
						top = stack.pop();
						count++;
					}
					if (count == 1) {
						return 1;
					}
				}
			} else {
				stack.add(c);
			}
		}

		return 0;
	}

	public static void main(final String[] args) {
		new Solutions().simplifyPath("/a/./b/../../c/");
	}
}
