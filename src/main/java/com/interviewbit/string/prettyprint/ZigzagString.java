package com.interviewbit.string.prettyprint;

import java.util.Arrays;

public class ZigzagString {
    public String convert(final String A, final int B) {
        if (B == 1) {
            return A;
        }
        final char[] str1 = A.toCharArray();

        // Find length of string
        final int len = A.length();

        // Create an array of
        // strings for all n rows
        final String[] arr = new String[B];
        Arrays.fill(arr, "");
        int row = 0;
        boolean down = true;
        for (int i = 0; i < len; ++i) {
            arr[row] += (str1[i]);
            if (row == (B - 1)) {
                down = false;
            }
            else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            }
            else {
                row--;
            }
        }
        String result = "";
        for (int i = 0; i < B; ++i) {
            result += arr[i];
        }
        return result;
    }
}
