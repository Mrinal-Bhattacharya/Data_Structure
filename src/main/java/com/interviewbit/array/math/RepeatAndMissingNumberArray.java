package com.interviewbit.array.math;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {
	public ArrayList<Integer> repeatedNumber(final List<Integer> copy) {
		final List<Integer> A = new ArrayList<>();
		A.addAll(copy);
		final ArrayList<Integer> out = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			final int abs = Math.abs(A.get(i));
			if (A.get(abs - 1) > 0) {
				A.set(abs - 1, -A.get(abs - 1));
			} else {
				out.add(abs);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > 0) {
				out.add(i + 1);
			}
		}
		return out;
	}
}
