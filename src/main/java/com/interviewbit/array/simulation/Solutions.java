package com.interviewbit.array.simulation;

import java.util.ArrayList;
import java.util.Collections;

public class Solutions {
	public ArrayList<ArrayList<Integer>> generateMatrix(final int A) {
		final ArrayList<ArrayList<Integer>> output = new ArrayList<>(A);
		final int arr[][] = new int[A][A];
		int t = 0, b = A - 1, l = 0, r = A - 1;
		int dir = 0;
		int value = 1;
		while ((t <= b) && (l <= r)) {
			if (dir == 0) {
				for (int i = l; i <= r; i++) {
					arr[t][i] = value++;
				}
				t++;
			} else if (dir == 1) {
				for (int i = t; i <= b; i++) {
					arr[i][r] = value++;
				}
				r--;
			} else if (dir == 2) {
				for (int i = r; i >= l; i--) {
					arr[b][i] = value++;
				}
				b--;
			} else if (dir == 3) {
				for (int i = b; i >= t; i--) {
					arr[i][l] = value++;
				}
				l++;
			}
			dir = (dir + 1) % 4;
		}
		for (int i = 0; i < A; i++) {
			final ArrayList<Integer> arrayList = new ArrayList<>(A);
			for (int j = 0; j < A; j++) {
				arrayList.add(arr[i][j]);
			}
			output.add(arrayList);
		}
		return output;
	}

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

	public static void main(final String[] args) {
		final ArrayList<ArrayList<Integer>> generateMatrix = new Solutions().generateMatrix(4);
		System.out.println(generateMatrix);
	}
}
