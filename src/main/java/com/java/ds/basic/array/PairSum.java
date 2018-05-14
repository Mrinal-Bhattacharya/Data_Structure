package com.java.ds.basic.array;

import java.util.Arrays;

public class PairSum implements Comparable<PairSum> {
	int first;
	int sec;
	int sum;

	@Override
	public int compareTo(final PairSum o) {
		return this.sum - o.sum;
	}

	static boolean noCommon(final PairSum a, final PairSum b) {
		if ((a.first == b.first) || (a.first == b.sec) || (a.sec == b.first) || (a.sec == b.sec)) {
			return false;
		}
		return true;
	}

	static void findFourElements(final int arr[], final int n, final int X) {
		int i, j;

		// Create an auxiliary array to store all pair sums
		final int size = (n * (n - 1)) / 2;
		final PairSum[] aux = new PairSum[size];

		/*
		 * Generate all possible pairs from A[] and store sums of all possible pairs in
		 * aux[]
		 */
		int k = 0;
		for (i = 0; i < (n - 1); i++) {
			for (j = i + 1; j < n; j++) {
				final PairSum pairSum = new PairSum();
				pairSum.sum = arr[i] + arr[j];
				pairSum.first = i;
				pairSum.sec = j;
				aux[k] = pairSum;
				k++;
			}
		}

		Arrays.sort(aux);

		// Now start two index variables from two corners of array
		// and move them toward each other.
		i = 0;
		j = size - 1;
		while ((i < size) && (j >= 0)) {
			if (((aux[i].sum + aux[j].sum) == X) && PairSum.noCommon(aux[i], aux[j])) {
				System.out.println(
						arr[aux[i].first] + " " + arr[aux[i].sec] + " " + arr[aux[j].first] + " " + arr[aux[j].sec]);
				return;
			} else if ((aux[i].sum + aux[j].sum) < X) {
				i++;
			} else {
				j--;
			}
		}
	}

	public static void main(final String[] args) {
		final int arr[] = { 10, 20, 30, 40, 1, 2 };
		final int X = 91;
		PairSum.findFourElements(arr, 6, X);
	}
}
