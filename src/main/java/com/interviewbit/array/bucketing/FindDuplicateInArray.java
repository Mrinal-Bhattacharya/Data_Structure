package com.interviewbit.array.bucketing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInArray {
	public int repeatedNumber(final List<Integer> A) {
		final Map<Integer, Integer> map = new HashMap<>();
		for (final Integer i : A) {
			if (map.containsKey(i)) {
				return i;
			}
			map.put(i, i);
		}
		return -1;
	}
}
