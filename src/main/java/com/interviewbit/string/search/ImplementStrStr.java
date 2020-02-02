package com.interviewbit.string.search;

public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        if ((A == null) || (B == null)) {
            return -1;
        }
        for (int i = 0; i < ((A.length() - B.length()) + 1); i++) {
            int j;
            for (j = 0; j < B.length(); j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    break;
                }
            }
            if (j == B.length()) {
                return i;
            }
        }
        return -1;
    }
}
