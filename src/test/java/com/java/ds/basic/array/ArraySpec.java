package com.java.ds.basic.array;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArraySpec {

	@Test
	public void longestSpanOfSameSumInArraysBinary() throws Exception {
		final int arr1[] = { 0, 1, 0, 0, 0, 0 };
		final int arr2[] = { 1, 0, 1, 0, 0, 1 };
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
}
