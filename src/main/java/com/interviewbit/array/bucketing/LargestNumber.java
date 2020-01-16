package com.interviewbit.array.bucketing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	public String largestNumber(final List<Integer> A) {
		Collections.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(final Integer X, final Integer Y) {
				final String XY = "" + X + Y;
				final String YX = "" + Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});
		String output = "";
		for (final Integer i : A) {
			output += i;
		}
		return output.charAt(0) == '0' ? "0" : output;
	}
}
