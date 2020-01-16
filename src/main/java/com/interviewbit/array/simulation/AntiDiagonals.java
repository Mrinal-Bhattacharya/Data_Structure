package com.interviewbit.array.simulation;

import java.util.ArrayList;
import java.util.Collections;

public class AntiDiagonals {
	public ArrayList<ArrayList<Integer>> diagonal(final ArrayList<ArrayList<Integer>> A) {
		final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		final int row = A.size();
		final int column = A.get(0).size();
		for (int k = 0; k < row; k++) {
			int i = k;
			int j = 0;
			final ArrayList<Integer> sublist = new ArrayList<>();
			while (i >= 0) {
				sublist.add(A.get(i).get(j));
				i--;
				j++;
			}
			Collections.reverse(sublist);
			output.add(sublist);
		}
		for (int k = 1; k < column; k++) {
			int i = row - 1;
			int j = k;
			final ArrayList<Integer> sublist = new ArrayList<>();
			while (j < column) {
				sublist.add(A.get(i).get(j));
				i--;
				j++;
			}
			Collections.reverse(sublist);
			output.add(sublist);
		}
		return output;
	}
}
