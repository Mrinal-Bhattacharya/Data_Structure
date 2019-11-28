package com.interviewbit.twopointers.inplaceupdate;

import java.util.ArrayList;

public class Solutions {
	public int removeDuplicates(final ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return a.size();
		}
		int i = 1;
		int j = 1;
		while (i < a.size()) {
			if (!a.get(i).equals(a.get(i - 1))) {
				a.set(j, a.get(i));
				j++;
			}
			i++;
		}
		final ArrayList<Integer> itemsToKeep = new ArrayList<>();
		i = 0;
		while (i < j) {
			itemsToKeep.add(a.get(i++));
		}
		a.clear();
		for (final int num : itemsToKeep) {
			a.add(num);
		}
		return a.size();
	}

	public int removeDuplicates2(final ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return a.size();
		}
		int i = 1;
		int j = 1;
		boolean twice = false;

		while (i < a.size()) {
			if (!a.get(i).equals(a.get(i - 1))) {
				a.set(j, a.get(i));
				j++;
				twice = false;
			} else {
				if (!twice) {
					a.set(j, a.get(i));
					twice = true;
					j++;
				}
			}
			i++;
		}

		final ArrayList<Integer> itemsToKeep = new ArrayList<>();
		i = 0;
		while (i < j) {
			itemsToKeep.add(a.get(i++));
		}

		a.clear();
		for (final int num : itemsToKeep) {
			a.add(num);
		}

		return a.size();
	}

	public int removeElement(final ArrayList<Integer> a, final int b) {
		final int n = a.size();
		int i = 0;
		for (int j = 0; j < n; j++) {
			if (a.get(j) != b) {
				a.set(i, a.get(j));
				i++;
			}
		}
		return i;
	}

	public void sortColors(final ArrayList<Integer> a) {
		int lo = 0;
		int hi = a.size() - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (a.get(mid)) {
			case 0: {
				temp = a.get(lo);
				a.set(lo, a.get(mid));
				a.set(mid, temp);
				lo++;
				mid++;
				break;
			}
			case 1: {
				mid++;
				break;
			}
			case 2: {
				temp = a.get(mid);
				a.set(mid, a.get(hi));
				a.set(hi, temp);
				hi--;
				break;
			}
			}
		}
	}
}
