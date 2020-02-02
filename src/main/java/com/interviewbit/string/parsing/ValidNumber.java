package com.interviewbit.string.parsing;

public class ValidNumber {
    /*
     * Using Regex = (0 or more Spaces) followed by (- or + sign ) followed by (0 to
     * 9 numbers) 0 or more followed by (.) followed by (0 - 9 numbers) one or more
     * followed by (e) followed by (- or + sign) followed by (0 to 9 numbers) one or
     * more followed by (0 or more spaces)
     */
    public int isNumber(final String A) {
        return (A.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }
}
