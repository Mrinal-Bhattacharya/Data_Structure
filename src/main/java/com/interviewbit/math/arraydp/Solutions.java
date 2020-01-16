package com.interviewbit.math.arraydp;

import java.util.ArrayList;
import java.util.List;

public class Solutions {

	public int solve(final ArrayList<Integer> A, int B, final int C) {
		int base = 10;

		final List<Integer> values = new ArrayList<>();
		if (B == 1) {
			base = 0;
			B = 10;
		} else {
			base = (int) Math.pow(10, B - 1);
			B = (int) Math.pow(10, B);
		}
		for (int i = base; (i < C) && (i < B); i++) {
			boolean flag = true;
			int num = i;
			if ((num == 0) && !A.contains(num)) {
				continue;
			}
			while (num != 0) {
				if (!A.contains(num % 10)) {
					flag = false;
					break;
				}
				num /= 10;
			}
			if (flag == true) {
				values.add(i);
			}
		}
		return values.size();
	}

	public static void main(final String[] args) {
		final ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(3);
		A.add(1);
		A.add(6);
		A.add(7);
		A.add(4);
		System.out.println(new Solutions().solve(A, 4, 59172));
	}
}
