package com.interviewbit.stack.math;

import java.util.List;
import java.util.Stack;

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int ans = 0;
        int current = 0;
        final Stack<Integer> st = new Stack<>();
        while (current < A.size()) {
            while (!st.empty() && (A.get(current) > A.get(st.peek()))) {
                final int top = st.pop();
                if (st.empty())
                    break;
                final int distance = current - st.peek() - 1;
                final int bounded_height = Math.min(A.get(current), A.get(st.peek())) - A.get(top);
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;

    }
    public int trap3(final List<Integer> A) {
        int left = 0;
        int right = A.size() - 1;
        int ans = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (left <= right) {
            if (A.get(left) < A.get(right)) {
                if (A.get(left) >= leftmax) {
                    leftmax = A.get(left);
                } else {
                    ans += leftmax - A.get(left);
                }
                left++;
            } else {
                if (A.get(right) >= rightmax) {
                    rightmax = A.get(right);
                } else {
                    ans += rightmax - A.get(right);
                }
                right--;
            }
        }
        return ans;
    }
}
