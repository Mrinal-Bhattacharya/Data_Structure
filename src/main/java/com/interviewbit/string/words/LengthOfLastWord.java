package com.interviewbit.string.words;

public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        final String A1 = A.trim();
        if (A1.contains(" ") && (A1.length() > 1)) {
            final int i = A1.lastIndexOf(" ");
            return (A1.length() - 1) - i;
        }
        else {
            return A1.length();
        }
    }
}
