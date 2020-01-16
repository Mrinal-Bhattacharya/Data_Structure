package com.interviewbit.math.numberencoding;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArray {
	public void arrange(final List<Integer> a) {
		// First step: Increase all values by (arr[arr[i]]%n)*n
		final int n = a.size();
		for (int i = 0; i < n; i++) {
			a.set(i, a.get(i) + ((a.get(a.get(i)) % n) * n));
		}

		// Second Step: Divide all values by n
		for (int i = 0; i < n; i++) {
			a.set(i, a.get(i) / n);
		}
	}

	void rearrange(final int arr[], final int n) {
		// First step: Increase all values by (arr[arr[i]]%n)*n
		for (int i = 0; i < n; i++) {
			arr[i] += (arr[arr[i]] % n) * n;
		}

		// Second Step: Divide all values by n
		for (int i = 0; i < n; i++) {
			arr[i] /= n;
		}
	}

	public static void main(final String[] args) {
		final List<Integer> a = new ArrayList<>();
		a.add(4);
		a.add(0);
		a.add(2);
		a.add(1);
		a.add(3);

		new RearrangeArray().arrange(a);
	}
}
