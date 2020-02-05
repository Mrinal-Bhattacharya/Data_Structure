package com.interviewbit.stack.cleverstack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(final ArrayList<Integer> A) {
        final ArrayList<Integer> ans = new ArrayList<>();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && (stack.peek() >= A.get(i))) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(A.get(i));
        }

        return ans;
    }
}
