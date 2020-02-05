package com.interviewbit.backtracking.maths;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(final int a) {
		final int len = 1 << a;
		final ArrayList<Integer> res = new ArrayList<>(len);
		res.add(0);
		for (int i = 1; i <= a; i++) {
			for (int j = res.size() - 1; j >= 0; j--) {
				final int next = res.get(j) | (1 << (i - 1));
				res.add(next);
			}
		}
		return res;
	}

	public static void main(final String[] args) {
		new GrayCode().grayCode(2);
	}
}
