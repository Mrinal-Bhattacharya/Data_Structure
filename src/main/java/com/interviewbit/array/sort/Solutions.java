package com.interviewbit.array.sort;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
	void quicksort(final int[] arr, final int n) {
		for (int i = 0; i < (n - 2); i++) {
			int iMin = i;
			for (int j = i + 1; j < (n - 1); j++) {
				if (arr[j] < arr[iMin]) {
					iMin = j;
				}
			}
			final int temp = arr[i];
			arr[i] = arr[iMin];
			arr[iMin] = temp;
		}
	}

	void bubblesort(final int[] arr, final int n) {
		for (int i = 1; i < (n - 1); i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (arr[j] > arr[j + 1]) {
					final int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	void insertionsort(final int[] arr, final int n) {
		for (int i = 1; i < (n - 1); i++) {
			final int value = arr[i];
			int hole = i;
			while ((hole > 0) && (arr[hole - 1] > value)) {
				arr[hole] = arr[hole - 1];
				hole = hole - 1;
			}
			arr[hole] = value;
		}
	}

	void mergeSort(final List<Integer> A) {
		if (A.size() <= 1) {
			return;
		}
		final int mid = A.size() / 2;
		final List<Integer> left = new ArrayList<>();
		final List<Integer> right = new ArrayList<>();
		for (int i = 0; i < mid; i++) {
			left.add(A.get(i));
		}
		for (int i = mid; i < A.size(); i++) {
			right.add(A.get(i));
		}
		this.mergeSort(left);
		this.mergeSort(right);
		this.merge(left, right, A);

	}

	private void merge(final List<Integer> left, final List<Integer> right, final List<Integer> a) {
		final int nL = left.size();
		final int nR = right.size();
		int i = 0, j = 0, k = 0;
		while ((i < nL) && (j < nR)) {
			if (left.get(i) < right.get(j)) {
				a.set(k, left.get(i));
				i++;
			} else {
				a.set(k, right.get(j));
				j++;
			}
			k++;
		}
		while (i < nL) {
			a.set(k, left.get(i));
			i++;
			k++;
		}
		while (j < nR) {
			a.set(k, right.get(j));
			j++;
			k++;
		}
	}

}
