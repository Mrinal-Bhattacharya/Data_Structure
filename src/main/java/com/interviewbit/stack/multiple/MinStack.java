package com.interviewbit.stack.multiple;

import java.util.Stack;

public class MinStack {
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(final int x) {
            this.stack.push(x);
            if (this.minStack.isEmpty() || (x <= this.minStack.peek())) {
                this.minStack.push(x);
            }
        }

        public void pop() {
            if (!this.stack.isEmpty()) {
                final int num = this.stack.pop();
                if (num == this.minStack.peek()) {
                    this.minStack.pop();
                }
            }
        }

        public int top() {
            if (this.stack.isEmpty()) {
                return -1;
            }
            return this.stack.peek();
        }

        public int getMin() {
            if (this.minStack.isEmpty()) {
                return -1;
            }
            return this.minStack.peek();
        }
}
