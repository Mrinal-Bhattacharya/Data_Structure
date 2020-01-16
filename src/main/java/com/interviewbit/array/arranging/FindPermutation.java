package com.interviewbit.array.arranging;

import java.util.ArrayList;

public class FindPermutation {
	public ArrayList<Integer> findPerm(final String A, final int B) {
		final ArrayList<Integer> result = new ArrayList<>();
		int max = B;
		int min = 1;

		for (final char c : A.toCharArray()) {
			if (c == 'D') {
				result.add(max);
				max--;
			} else {
				result.add(min);
				min++;
			}
		}
		result.add(min);
		return result;
	}
}
