package com.interviewbit.binarysearch.searchanswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solutions {
	public int books(final List<Integer> A, final int B) {
		if (B > A.size()) {
			return -1;
		}
		final long total_pages = A.stream().collect(Collectors.summingInt(Integer::intValue));
		long s = A.stream().max(Comparator.comparing(Integer::valueOf)).get();
		long e = total_pages;
		long finalAns = 0;
		while (s <= e) {
			final long mid = (s + e) / 2;
			if (this.isValidConfig(A, B, mid)) {
				finalAns = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return (int) finalAns;
	}

	private boolean isValidConfig(final List<Integer> books, final int totalStudents, final long ans) {
		int students = 1;
		long currentpages = 0;
		for (int i = 0; i < books.size(); i++) {
			currentpages += books.get(i);
			if (currentpages > ans) {
				currentpages = books.get(i);
				students++;
			}
			if (students > totalStudents) {
				return false;
			}
		}
		return true;
	}

	public int paint(final int painters, final int timeUnit, final ArrayList<Integer> boards) {
		long high = boards.stream().collect(Collectors.summingInt(Integer::intValue));
		long low = boards.stream().max(Comparator.comparing(Integer::valueOf)).get();
		long finalAns = 0;
		while (low <= high) {
			final long mid = (low + high) / 2;
			if (this.isPossible(painters, timeUnit, boards, mid)) {
				finalAns = mid % 10000003;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return (int) ((finalAns * timeUnit) % 10000003);
	}

	private boolean isPossible(final int maxPainters, final int timeUnit, final ArrayList<Integer> boards,
			final long maxLengthPerPainter) {
		int painters = 1;
		int totalPaint = 0;
		for (int i = 0; i < boards.size(); i++) {
			totalPaint += boards.get(i);
			if (totalPaint > maxLengthPerPainter) {
				totalPaint = boards.get(i);
				painters++;
			}
			if (painters > maxPainters) {
				return false;
			}
		}
		return true;
	}

	public int sqrt(final int a) {
		int low = 0;
		int high = a;
		int result = 0;
		while (low <= high) {
			final int mid = low + (high / 2);
			if ((mid * mid) == a) {
				return mid;
			}
			if ((mid * mid) < a) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	public int findMedian(final ArrayList<ArrayList<Integer>> A) {
		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		final int total = A.size() * A.get(0).size();
		while (left <= right) {
			final int mid = (int) (left + (((long) right - left) / 2));
			final int smaller = this.countSmaller(A, mid);
			if (smaller > (total / 2)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	private int countSmaller(final ArrayList<ArrayList<Integer>> A, final int B) {
		int smaller = 0;
		for (int i = 0; i < A.size(); i++) {
			smaller += this.countSmaller(A.get(i), B);
		}
		return smaller;
	}

	private int countSmaller(final List<Integer> A, final int B) {
		int left = 0, right = A.size() - 1;
		while (left <= right) {
			final int mid = (left + right) / 2;
			if (B <= A.get(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(final String[] args) {
		final Integer[] arg0 = { 97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53,
				8, 44, 68, 90, 24 };
		System.out.println(new Solutions().books(Arrays.asList(arg0), 26));
	}
}
