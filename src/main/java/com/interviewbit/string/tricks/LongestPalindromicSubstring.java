package com.interviewbit.string.tricks;

public class LongestPalindromicSubstring {
    private int start, end, maxLength;

    public String longestPalindrome(final String A) {
        final int n = A.length();
        final boolean[][] palindrome = new boolean[n][n];
        int max_len = 1;
        int palindromeBeginAt = 0;
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }
        for (int i = 0; i < (n - 1); i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                palindromeBeginAt = i;
                max_len = 2;
                palindrome[i][i + 1] = true;
            }
        }
        for (int currlen = 3; currlen <= n; currlen++) {
            for (int i = 0; i < ((n - currlen) + 1); i++) {
                final int j = (i + currlen) - 1;
                if ((A.charAt(i) == A.charAt(j)) && palindrome[i + 1][j - 1]) {
                    palindromeBeginAt = i;
                    max_len = currlen;
                    palindrome[i][j] = true;
                }
            }
        }
        return A.substring(palindromeBeginAt, max_len + palindromeBeginAt);
    }

    // finds the longest palindrome with [left, right] as center
    private void checkPalindrome(String A, int left, int right) {
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            if (right - left + 1 > maxLength) {
                start = left;
                end = right + 1;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public String longestPalindromeInterviewBit(String A) {
        start = 0;
        end = 0;
        maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            checkPalindrome(A, i, i); // odd length, center in i
            checkPalindrome(A, i, i + 1); // even length, center between i and i + 1
        }
        return A.substring(start, end);
    }
}
