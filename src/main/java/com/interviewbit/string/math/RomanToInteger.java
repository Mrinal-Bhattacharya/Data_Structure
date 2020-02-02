package com.interviewbit.string.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {
    private static final Map<Character, Integer> ct = new HashMap<>();

    static {
        RomanToInteger.ct.put('I', 1);
        RomanToInteger.ct.put('V', 5);
        RomanToInteger.ct.put('X', 10);
        RomanToInteger.ct.put('L', 50);
        RomanToInteger.ct.put('C', 100);
        RomanToInteger.ct.put('D', 500);
        RomanToInteger.ct.put('M', 1000);
    }

    public int romanToInt(final String A) {
        int res = 0;

        for (int i = 0; i < A.length(); i++) {
            // Getting value of symbol s[i]
            final int s1 = this.value(A.charAt(i));

            // Getting value of symbol s[i+1]
            if ((i + 1) < A.length()) {
                final int s2 = this.value(A.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    res = res + s1;
                }
                else {
                    res = (res + s2) - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            }
            else {
                res = res + s1;
                i++;
            }
        }

        return res;
    }

    int value(final char r) {
        if (r == 'I') {
            return 1;
        }
        if (r == 'V') {
            return 5;
        }
        if (r == 'X') {
            return 10;
        }
        if (r == 'L') {
            return 50;
        }
        if (r == 'C') {
            return 100;
        }
        if (r == 'D') {
            return 500;
        }
        if (r == 'M') {
            return 1000;
        }
        return -1;
    }

    public int romanToInt2(final String A) {
        final Stack<Integer> stack = new Stack<>();

        final int length = A.length();
        for (int i = 0; i < length; i++) {
            final int value = RomanToInteger.ct.get(A.charAt(i));

            if (!stack.isEmpty() && (stack.peek() < value)) {
                final int prev = stack.pop();
                stack.push(value - prev);
            }
            else {
                stack.push(value);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
