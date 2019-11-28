package com.interviewbit.string.simulation;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	public int isPalindrome(final String A) {
		final int len = A.length();
		int start = 0, end = len - 1;

		while (start <= end) {
			if (!this.isAlphanumeric(A.charAt(start))) {
				start++;
			} else if (!this.isAlphanumeric(A.charAt(end))) {
				end--;
			} else if (Character.toLowerCase(A.charAt(start)) != Character.toLowerCase(A.charAt(end))) {
				return 0;
			} else {
				start++;
				end--;
			}
		}

		return 1;

	}

	public boolean isAlphanumeric(final char c) {
		return Character.isDigit(c) || Character.isLetter(c);
	}

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

	public String countAndSay(final int A) {
		StringBuilder builder = new StringBuilder();
		final String s1 = "1";
		if (A <= 1) {
			return s1;
		}
		String temp = s1;
		int j;
		for (int i = 2; i <= A; i++) {
			for (j = 0; j < temp.length(); j++) {
				int count = 1;
				final char ts = temp.charAt(j);
				while ((j < (temp.length() - 1)) && (temp.charAt(j) == temp.charAt(j + 1))) {
					count++;
					j++;
				}
				builder.append(count);
				builder.append(ts);
			}
			temp = builder.toString();
			builder = new StringBuilder();
		}
		return temp;
	}
}
