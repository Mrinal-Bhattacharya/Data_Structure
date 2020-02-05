package com.interviewbit.backtracking.prunedbuilder;

import java.util.ArrayList;

public class GenerateAllParenthesesII {
    public ArrayList<String> generateParenthesis(final int A) {
        final ArrayList<String> result = new ArrayList<>();
        this.parenthesisHelper("", A, A, result);
        return result;
    }

    private void parenthesisHelper(final String output, final int open, final int close,
                                   final ArrayList<String> result) {
        if ((close == 0) && (open == 0)) {
            result.add(output);
            return;
        }
        if (open > 0) {
            this.parenthesisHelper(output + "(", open - 1, close, result);
        }
        if (open < close) {
            this.parenthesisHelper(output + ")", open, close - 1, result);
        }

    }

    private void parenthesisHelper(final String output, final int open, final int close, final int pairs,
                                   final ArrayList<String> result, final int a) {
        System.out.println("output: " + output);
        if ((open == pairs) && (close == pairs) && (output.length() == (2 * a))) {
            System.out.println("\t Adding to result");
            result.add(output);
        } else {
            if (open < pairs) {
                System.out.println("\t Adding ( ");
                this.parenthesisHelper(output + "(", open + 1, close, pairs, result, a);
            }
            if (close < open) {
                System.out.println("\t Adding ) ");
                this.parenthesisHelper(output + ")", open, close + 1, pairs, result, a);
            }
        }
    }
}
