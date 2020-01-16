package com.interviewbit.array.simulation;

import java.util.ArrayList;

public class SpiralOrderMatrixII {
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

}
