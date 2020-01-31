package com.java.ds.basic.string;

public class Palindrom {
	public boolean isPalindrom(final String input) {
		int i = 0;
		int j = input.length();
		while ((i < j) && (input.charAt(i) == input.charAt(j))) {
			i++;
			j--;
		}
        return i >= j;
    }
}
