package com.interviewbit.math.baseconversion;

public class ExcelColumnNumber {
	public int titleToNumber(final String A) {
		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			result *= 26;
			result += (A.charAt(i) - 'A') + 1;
		}
		return result;
	}
}
