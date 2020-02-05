package com.interviewbit.backtracking.bruteforcebuilder;

import java.util.ArrayList;

public class GenerateAllParenthesesII {
    public ArrayList<String> generateParenthesis(final int A) {
        final ArrayList<String> result = new ArrayList<>();
        this.parenthesisHelper("", 0, 0, result, A);
        return result;
    }

    private void parenthesisHelper(final String output, final int open, final int close, final ArrayList<String> result,
                                   final int n) {
        if (close == n) {
            result.add(output);
            return;
        }
        if (open < n) {
            this.parenthesisHelper(output + "(", open + 1, close, result, n);
        }
        if (close < n) {
            this.parenthesisHelper(output + ")", open, close + 1, result, n);
        }

    }


}
