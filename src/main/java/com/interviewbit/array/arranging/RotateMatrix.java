package com.interviewbit.array.arranging;

import java.util.ArrayList;

public class RotateMatrix {
	public void rotate(final ArrayList<ArrayList<Integer>> a) {
		final int S = a.size() - 1;
		for (int i = 0; i < (a.size() / 2); i++) {
			for (int j = i; j < (S - i); j++) {
				// left bottom (2,0)
				final int temp1 = a.get(S - j).get(i);
				// right right bootom (2,2)
				final int temp2 = a.get(S - i).get(S - j);
				// right top (0,2)
				final int temp3 = a.get(j).get(S - i);
				// left top (0,0)
				final int temp4 = a.get(i).get(j);

				// swap
				a.get(i).set(j, temp1);
				a.get(S - j).set(i, temp2);
				a.get(S - i).set(S - j, temp3);
				a.get(j).set(S - i, temp4);
			}
		}
	}
}
