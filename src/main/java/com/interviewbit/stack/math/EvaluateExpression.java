package com.interviewbit.stack.math;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(final ArrayList<String> A) {
        final Stack<Integer> st = new Stack<>();
        A.size();
        for (int i = 0; i < A.size(); i++) {
            if ("*/-+".contains(A.get(i))) {
                final int a = st.pop();
                final int b = st.pop();
                if (A.get(i).equals("+")) {
                    st.push(b + a);
                } else if (A.get(i).equals("-")) {
                    st.push(b - a);
                } else if (A.get(i).equals("*")) {
                    st.push(b * a);
                } else {
                    st.push(b / a);
                }
            } else {
                st.push(Integer.parseInt(A.get(i)));
            }
        }
        return st.peek();
    }
}
