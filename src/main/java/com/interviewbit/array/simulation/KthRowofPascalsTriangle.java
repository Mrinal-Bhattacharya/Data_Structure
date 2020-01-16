package com.interviewbit.array.simulation;

import java.util.ArrayList;

public class KthRowofPascalsTriangle {
	public ArrayList<Integer> getRow(final int A) {
		final ArrayList<Integer> output = new ArrayList<>();
		int C = 1;// used to represent C(line, i)
		output.add(C);
		for (int i = 1; i <= A; i++) {
			// The first value in a line is always 1
			C = (C * ((A - i) + 1)) / i;
			output.add(C);
		}
		return output;
	}
}
