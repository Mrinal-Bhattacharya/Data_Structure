package com.interviewbit.string.programming;

public class AmazingSubarrays {
    public boolean isVowel(char a) {
        a = Character.toLowerCase(a);
        return (a == 'a') || (a == 'e') || (a == 'i') || (a == 'o') || (a == 'u');
    }

    public int solve(final String A) {
        int sum = 0;

        for (int i = 0; i < A.length(); i++) {
            if (this.isVowel(A.charAt(i))) {
                sum += A.length() - i;
            }
        }

        return sum % 10003;
    }

    public int solve2(final String A) {

        final String vow = "aeiouAEIOU";
        int count = 0;
        final int s = A.length();
        for (int i = 0; i < A.length(); i++) {
            if (vow.indexOf(A.charAt(i)) >= 0) {
                count += s - i;
            }
        }
        return count % 10003;
    }
}
