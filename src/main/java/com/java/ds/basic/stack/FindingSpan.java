package com.java.ds.basic.stack;

import java.util.Arrays;

public class FindingSpan {
	public int[] findingSpan(final int[] inputArr) {
		final int[] spans = new int[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			int span = 1;
			int j = i - 1;
			while ((j >= 0) && (inputArr[j] <= inputArr[j + 1])) {
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}

	public int[] findingSpanWithStack(final int[] inputArray) throws Exception {
		final int[] spans = new int[inputArray.length];
		final LinkedStack stack = new LinkedStack();
		int p = 0;
		for (int i = 0; i < inputArray.length; i++) {
			while (!stack.isEmpty() && (inputArray[i] > inputArray[stack.peek()])) {
				stack.pop();
			}
			p = stack.isEmpty() ? -1 : stack.peek();
			spans[i] = i - p;
			stack.push(i);
		}
		return spans;
	}

	public static void main(final String[] args) throws Exception {
		final int[] inputArray = { 6, 3, 4, 5, 2 };
		final int[] findingSpan = new FindingSpan().findingSpan(inputArray);
		System.out.println(Arrays.asList(findingSpan));
		final int[] findingSpan2 = new FindingSpan().findingSpanWithStack(inputArray);
		System.out.println(Arrays.asList(findingSpan2));
	}
}
