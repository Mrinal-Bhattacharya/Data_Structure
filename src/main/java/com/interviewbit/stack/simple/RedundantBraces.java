package com.interviewbit.stack.simple;

import java.util.Stack;

public class RedundantBraces {
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
}
