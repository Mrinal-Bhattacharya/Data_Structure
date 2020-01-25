package com.java.ds.basic.array;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

public class ArraySpec {

	@Test
	public void longestSpanOfSameSumInArraysBinary() throws Exception {
		final int arr1[] = { 0, 1, 2, 3, 0, 0 };
		final int arr2[] = { 1, 0, 1, 2, 3, 1 };
		final int result = new ArraySolutions().longestCommonSumSpan(arr1, arr2, arr1.length);
		final int result2 = new ArraySolutions().longestCommonSumSpan2(arr1, arr2, arr1.length);
		Assertions.assertThat(result).isEqualTo(4);
		Assertions.assertThat(result2).isEqualTo(4);

	}

	@Test
	public void union() throws Exception {
		final int arr1[] = { 1, 3, 4, 5, 7 };
		final int arr2[] = { 2, 3, 5, 6, };
		final List<Integer> union = new ArraySolutions().union(arr1, arr2, arr1.length, arr2.length);
		Assertions.assertThat(union).containsExactly(1, 2, 3, 4, 5, 6, 7);
	}

	@Test
	public void intersection() throws Exception {
		final int arr1[] = { 1, 3, 4, 5, 7 };
		final int arr2[] = { 2, 3, 5, 6, };
		final List<Integer> intersection = new ArraySolutions().intersection(arr1, arr2, arr1.length, arr2.length);
		Assertions.assertThat(intersection).containsExactly(3, 5);
	}

	@Test
	public void missingNo() throws Exception {
		final int arr1[] = { 1, 2, 3, 5, 6 };
		final int result = new ArraySolutions().missingNo(arr1, 5);
		Assertions.assertThat(result).isEqualTo(4);
	}

	@Test
	public void minDist() throws Exception {
		final int arr1[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		final int result = new ArraySolutions().minDist(arr1, 3, 6);
		Assertions.assertThat(result).isEqualTo(4);
	}

	@Test
	public void mooreMajorityAlgo() {
		final int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		final int result = new ArraySolutions().mooreMajorityAlgo(arr);
		Assertions.assertThat(arr[result]).isEqualTo(4);
	}

	@Test
	public void getOddOcuurence() {
		final int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		final int result = new ArraySolutions().getOddOccurence(arr);
		Assertions.assertThat(result).isEqualTo(4);
	}

	@Ignore
	@Test
	public void fixPoint() {
		final int arr[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		final int result = new ArraySolutions().fixPointByBinarySearch(arr, 0, arr.length - 1);
		Assertions.assertThat(result).isEqualTo(3);
	}

	@Test
	public void nextGreatest() {
		final int arr[] = { 16, 17, 4, 3, 5, 2 };
		new ArraySolutions().nextGreatest(arr, arr.length);
		Assertions.assertThat(arr).containsExactly(17, 5, 5, 5, 2, -1);
	}

	@Test
	public void findPeek() {
		final int arr[] = { 10, 20, 15, 2, 23, 90, 67 };
		final int result = new ArraySolutions().findPeek(arr, 0, arr.length - 1, arr.length);
		Assertions.assertThat(result).isEqualTo(1);
	}

	@Test
	public void countIncressing() {
		final int arr[] = { 1, 2, 2, 4 };
		final int result = new ArraySolutions().countIncreasing(arr, arr.length);
		Assertions.assertThat(result).isEqualTo(2);
	}

	void printRepeating(final int arr[], final int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}
	}

	public static void main(final String[] args) {
		final int arr[] = { 1, 3, 2, 1, 3, 6, 6 };
		final int arr_size = arr.length;
		final ArraySpec a = new ArraySpec();
		// a.printRepeating(arr, arr_size);
		a.printRepeating1(arr, arr_size);
		// System.out.println(s);
	}

	void printRepeating1(final int arr[], final int n) {
		// First check all the values that are
		// present in an array then go to that
		// values as indexes and increment by
		// the size of array
		for (int i = 0; i < n; i++) {
			final int index = arr[i] % n;
			arr[index] += n;
		}

		// Now check which value exists more
		// than once by dividing with the size
		// of array
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void testLinkedHashMap() {
		final int MAX_ENTRIES = 5;
		final LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>(10, (float) .75,
				true) {
			@Override
			protected boolean removeEldestEntry(final Map.Entry eldest) {
				return this.size() > MAX_ENTRIES;
			}
		};
		linkedHashMap.put(1, 10);
		linkedHashMap.put(2, 10);

	}

	@Test
	public void printSpiral() {
		final int[][] a = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		new ArraySolutions().spiralPrint(3, 6, a);
	}

}
