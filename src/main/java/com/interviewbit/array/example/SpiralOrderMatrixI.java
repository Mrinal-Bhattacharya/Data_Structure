package com.interviewbit.array.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
	public static void main(final String[] args) {
		final List<ArrayList<Integer>> array = new ArrayList<>();
		final ArrayList<Integer> sublist = new ArrayList<>();
		sublist.add(1);
		sublist.add(2);
		array.add(sublist);
		final ArrayList<Integer> sublist1 = new ArrayList<>();
		sublist1.add(3);
		sublist1.add(4);
		array.add(sublist1);
		final ArrayList<Integer> sublist2 = new ArrayList<>();
		sublist2.add(5);
		sublist2.add(6);
		array.add(sublist2);
		new SpiralOrderMatrixI().spiralOrder(array);
		System.out.println(array);
	}

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		final ArrayList<Integer> output = new ArrayList<>();
		int t = 0, b = A.size() - 1, l = 0, r = A.get(0).size() - 1;
		int dir = 0;
		while ((t <= b) && (l <= r)) {
			if (dir == 0) {
				for (int i = l; i <= r; i++) {
					output.add(A.get(t).get(i));
				}
				t++;
			} else if (dir == 1) {
				for (int i = t; i <= b; i++) {
					output.add(A.get(i).get(r));
				}
				r--;
			} else if (dir == 2) {
				for (int i = r; i >= l; i--) {
					output.add(A.get(b).get(i));
				}
				b--;
			} else if (dir == 3) {
				for (int i = b; i >= t; i--) {
					output.add(A.get(i).get(l));
				}
				l++;
			}
			dir = (dir + 1) % 4;
		}
		return output;
	}
}
