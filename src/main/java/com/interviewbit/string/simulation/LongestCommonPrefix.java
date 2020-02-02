package com.interviewbit.string.simulation;

import java.util.ArrayList;
import java.util.Collections;

public class LongestCommonPrefix {
    public String longestCommonPrefix(final ArrayList<String> A) {
        final int size = A.size();
        if (size == 0) {
            return "";
        }
        if (size == 1) {
            return A.get(0);
        }
        Collections.sort(A);
        final int end = Math.min(A.get(0).length(), A.get(size - 1).length());
        int start = 0;
        while ((start < end) && (A.get(0).charAt(start) == A.get(size - 1).charAt(start))) {
            start++;
        }
        final String pre = A.get(0).substring(0, start);
        return pre;
    }
}
