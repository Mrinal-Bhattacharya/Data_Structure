package com.interviewbit.string.simulation;

public class PalindromeString {
    public int isPalindrome(final String A) {
        final int len = A.length();
        int start = 0, end = len - 1;

        while (start <= end) {
            if (!this.isAlphanumeric(A.charAt(start))) {
                start++;
            }
            else if (!this.isAlphanumeric(A.charAt(end))) {
                end--;
            }
            else if (Character.toLowerCase(A.charAt(start)) != Character.toLowerCase(A.charAt(end))) {
                return 0;
            }
            else {
                start++;
                end--;
            }
        }

        return 1;

    }

    public boolean isAlphanumeric(final char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
