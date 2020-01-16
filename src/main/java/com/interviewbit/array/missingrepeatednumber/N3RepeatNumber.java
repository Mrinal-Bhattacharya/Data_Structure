package com.interviewbit.array.missingrepeatednumber;

import java.util.List;

public class N3RepeatNumber {
	public int repeatedNumberNDiv3(final List<Integer> a) {
		if (a.size() < 2) {
			return a.get(0);
		}
		int count1 = 0, count2 = 0;

		// take the integers as the maximum
		// value of integer hoping the integer
		// would not be present in the array
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		for (int i = 1; i < a.size(); i++) {

			// if this element is previously
			// seen, increment count1.
			if (first == a.get(i)) {
				count1++;
			} else if (second == a.get(i)) {
				count2++;
			} else if (count1 == 0) {
				count1++;
				first = a.get(i);
			}

			else if (count2 == 0) {
				count2++;
				second = a.get(i);
			}

			// if current element is different
			// from both the previously seen
			// variables, decrement both the
			// counts.
			else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		// Again traverse the array and
		// find the actual counts.
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == first) {
				count1++;
			} else if (a.get(i) == second) {
				count2++;
			}
		}

		if (count1 > (a.size() / 3)) {
			return first;
		}

		if (count2 > (a.size() / 3)) {
			return second;
		}

		return -1;
	}
}
