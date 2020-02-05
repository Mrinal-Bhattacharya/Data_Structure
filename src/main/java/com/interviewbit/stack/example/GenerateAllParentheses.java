package com.interviewbit.stack.example;

import java.util.Stack;

public class GenerateAllParentheses {
    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c= A.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char top = stack.peek();
                if ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')) {
                    stack.pop();
                } else
                    return 0;
            }
        }
        if (!stack.isEmpty())
            return 0;
        return 1;
    }
}
