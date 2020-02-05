package com.interviewbit.stack.simple;

import java.util.Stack;

public class SimplifyDirectoryPath {
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
}
