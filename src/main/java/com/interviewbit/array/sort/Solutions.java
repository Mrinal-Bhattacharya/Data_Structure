package com.interviewbit.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {
	void selectionSort(final int[] arr, final int n) {
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

	void quickSort(final List<Integer> A, final int start, final int end) {
		if (start < end) {
			final int pIndex = this.partition(A, start, end);
			this.quickSort(A, start, pIndex - 1);
			this.quickSort(A, pIndex + 1, end);
		}
	}

	private int partition(final List<Integer> A, final int start, final int end) {
		final int pivot = A.get(end);
		int pIndex = start;
		for (int i = start; i < (end - 1); i++) {
			if (A.get(i) < pivot) {
				final int temp = A.get(i);
				A.set(i, A.get(pIndex));
				A.set(pIndex, temp);
				pIndex++;

			}
		}
		final int temp = A.get(end);
		A.set(end, A.get(pIndex));
		A.set(pIndex, temp);
		return pIndex;
	}

	void redixSort(final int[] arr, final int n) {
		final int m = Arrays.stream(arr).max().getAsInt();
		for (int i = 1; (m / i) > 0; i *= 10) {
			this.countSort(arr, n, i);
		}
	}

	private void countSort(final int[] arr, final int n, final int exp) {
		final int[] output = new int[n];
		int i;
		final int[] count = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
}
