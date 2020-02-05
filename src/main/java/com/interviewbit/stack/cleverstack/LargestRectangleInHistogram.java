package com.interviewbit.stack.cleverstack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(final ArrayList<Integer> A) {
        if ((null == A) || A.isEmpty()) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        }
        int max = 0;
        final Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || (A.get(stack.peek()) <= A.get(i))) {
                stack.push(i);
                i++;
            } else {
                final int top = stack.pop();
                final int height = A.get(top);
                final int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, height * width);
            }
        }
        while (!stack.isEmpty()) {
            final int top = stack.pop();
            final int height = A.get(top);
            final int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
            max = Math.max(max, height * width);
        }
        return max;
    }

    public int largestRectangleArea2(final ArrayList<Integer> A) {
        int max_rectangle = 0;
        for (int i = 0; i < A.size(); i++) {
            final int H = A.get(i);
            int L = i;
            int R = i;
            while ((L >= 0) && (A.get(L) >= H)) {
                L = L - 1;
            }
            while ((R < A.size()) && (A.get(R) >= H)) {
                R = R + 1;
            }
            max_rectangle = Math.max(max_rectangle, (R - L - 1) * H);
        }
        return max_rectangle;
    }
}
