package com.java.ds.basic.array;

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
}
