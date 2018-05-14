package com.interviewbit.math.baseconversion;

public class Solutions {

	public int titleToNumber(final String A) {
		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			result *= 26;
			result += (A.charAt(i) - 'A') + 1;
		}
		return result;
	}

	public String convertToTitle(int A) {
		String str = "";

		while (A != 0) {
			final int rem = (A % 26);
			if (rem == 0) {
				str = 'Z' + str;
			} else {
				final int value = (rem + 'A') - 1;
				str = Character.toString((char) value) + str;
			}
			A--;
			A = A / 26;
		}
		return str;
	}

}
