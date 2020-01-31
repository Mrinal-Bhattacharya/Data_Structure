package com.interviewbit.math.baseconversion;

public class ExcelColumnTitle {
	public String convertToTitle(int A) {
		String str = "";

		while (A != 0) {
			final int rem = (A % 26);
			if (rem == 0) {
				str = 'Z' + str;
			} else {
				final int value = (rem + 'A') - 1;
                str = (char) value + str;
			}
			A--;
			A = A / 26;
		}
		return str;
	}
}
