package com.interviewbit.array.simulation;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> pascal(final int A) {
		final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (int line = 0; line < A; line++) {
			// Every line has number of integers
			// equal to line number
			final ArrayList<Integer> arrayList = new ArrayList<>();
			output.add(arrayList);
			for (int i = 0; i <= line; i++) {
				// First and last values in every row are 1
				if ((line == i) || (i == 0)) {
					arrayList.add(1);
				} else {
					arrayList.add(output.get(line - 1).get(i - 1) + output.get(line - 1).get(i));
				}
			}
		}
		return output;
	}
}
