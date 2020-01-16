package com.interviewbit.math.digitop;

public class PalindromeInteger {
	public int isPalindrome(final int A) {
		if ((A >= 0) && (A < 10)) {
			return 1;
		}
		String str = "";
		int n = Math.abs(A);
		while (n != 0) {
			str += n % 10;
			n = n / 10;
		}
		if (String.valueOf(A).equals(str)) {
			return 1;
		}
		return 0;
	}

}
