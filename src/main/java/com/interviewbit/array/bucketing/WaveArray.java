package com.interviewbit.array.bucketing;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
	public ArrayList<Integer> wave(final ArrayList<Integer> A) {
		Collections.sort(A);
		for (int i = 0; i < (A.size() - 1); i += 2) {
			final int temp = A.get(i);
			A.set(i, A.get(i + 1));
			A.set(i + 1, temp);
		}
		return A;
	}
}
