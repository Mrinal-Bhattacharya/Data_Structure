package com.interviewbit.array.bucketing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solutions {
	int nobleIntNaive(final int[] arr) {
		final int size = arr.length;
		for (int i = 0; i < size; i++) {
			int count = 0;
			for (int j = 0; j < size; j++) {
				if (arr[i] < arr[j]) {
					count++;
				}
			}
			// If count of greater elements
			// is equal to arr[i]
			if (count == arr[i]) {
				return arr[i];
			}
		}
		return -1;
	}

	int nobleIntNaive(final List<Integer> arr) {
		Collections.sort(arr);

		// Return a Noble element if present
		// before last.
		final int n = arr.size();
		for (int i = 0; i < (n - 1); i++) {
			if (arr.get(i) == arr.get(i + 1)) {
				continue;
			}

			// In case of duplicates, we
			// reach last occurrence here.
			if (arr.get(i) == (n - i - 1)) {
				return arr.get(i);
			}
		}

		if (arr.get(n - 1) == 0) {
			return arr.get(n - 1);
		}

		return -1;
	}

	public String largestNumber(final List<Integer> A) {
		Collections.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(final Integer X, final Integer Y) {
				final String XY = "" + X + Y;
				final String YX = "" + Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});
		String output = "";
		for (final Integer i : A) {
			output += i;
		}
		return output.charAt(0) == '0' ? "0" : output;
	}

	public boolean hotelInterval(final ArrayList<Integer> arrive, final ArrayList<Integer> depart, final int K) {
		final Interval[] intervals = new Interval[arrive.size()];
		for (int i = 0; i < arrive.size(); i++) {
			intervals[i] = new Interval(arrive.get(i), depart.get(i));
		}
		Arrays.sort(intervals);
		int rooms = K;
		rooms--;
		for (int i = 1; i < (arrive.size()); i++) {
			if (intervals[i].d < intervals[i + 1].a) {
				if (rooms > 0) {
					rooms--;
					continue;
				}
			} else if (intervals[i].a < intervals[i - 1].d) {
				return false;
			}
		}
		return true;
	}

	public boolean hotel(final ArrayList<Integer> arrive, final ArrayList<Integer> depart, final int K) {

		Collections.sort(arrive);
		Collections.sort(depart);
		int i = 0, j = 0, c = 0;
		while ((i < arrive.size()) && (j < depart.size())) {
			if (arrive.get(i) < depart.get(j)) {
				c++;
				i++;
			} else {
				c--;
				j++;
			}
			if (c > K) {
				return false;
			}
		}
		return true;
	}

	class Interval implements Comparable<Interval> {
		int a;
		int d;

		public Interval(final int a, final int d) {
			this.a = a;
			this.d = d;
		}

		@Override
		public int compareTo(final Interval that) {
			return this.a - that.a;
		}

	}

	public int maximumGap(final List<Integer> A) {
		if (A.size() < 2) {
			return 0;
		}
		int maxDiff;
		int i, j;
		final int n = A.size();
		final int RMax[] = new int[A.size()];
		final int LMin[] = new int[A.size()];
		LMin[0] = A.get(0);
		for (i = 1; i < n; ++i) {
			LMin[i] = Math.min(A.get(i), LMin[i - 1]);
		}
		RMax[n - 1] = A.get(n - 1);
		for (j = n - 2; j >= 0; --j) {
			RMax[j] = Math.max(A.get(j), RMax[j + 1]);
		}
		i = 0;
		j = 0;
		maxDiff = -1;
		while ((j < n) && (i < n)) {
			if (LMin[i] <= RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else {
				i = i + 1;
			}
		}

		return maxDiff;
	}

	public ArrayList<Integer> subUnsort(final ArrayList<Integer> A) {
		final ArrayList<Integer> list = new ArrayList<>();
		int st = -1, end = -1;

		// from left
		for (int i = 1; i < A.size(); ++i) {
			if (A.get(i) < A.get(i - 1)) {
				st = i - 1;
				break;
			}
		}

		// fully sorted
		if (st == -1) {
			list.add(-1);
			return list;
		}

		// from right
		for (int i = A.size() - 2; i >= 0; --i) {
			if (A.get(i) > A.get(i + 1)) {
				end = i + 1;
				break;
			}
		}

		// find min and max in the range [st, end]
		int min = A.get(st);
		int max = A.get(st);
		for (int i = st; i <= end; ++i) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}

		for (int i = 0; i < st; ++i) {
			if (A.get(i) > min) {
				st = i;
				break;
			}
		}

		for (int i = A.size() - 1; i >= (end + 1); --i) {
			if (A.get(i) < max) {
				end = i;
				break;
			}
		}

		list.add(st);
		list.add(end);

		return list;
	}

	public int maxGap(final List<Integer> A) {
		final int n = A.size();
		if (n < 2) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, A.get(i));
			min = Math.min(min, A.get(i));
		}
		// n-1 buckets - we only care about max and min in each buckets
		final int[] bucketMaxima = new int[n - 1];
		Arrays.fill(bucketMaxima, Integer.MIN_VALUE);
		final int[] bucketMinima = new int[n - 1];
		Arrays.fill(bucketMinima, Integer.MAX_VALUE);
		// bucket width or bucketgaps like delta 1.33 then 1--2.33--3.66--4.99
		final float delta = (max - min) / ((float) n - 1);
		for (int i = 0; i < n; i++) {
			if ((A.get(i) == max) || (A.get(i) == min)) {
				continue;
			}
			final int bucketIndex = (int) Math.floor((A.get(i) - min) / delta);
			bucketMaxima[bucketIndex] = bucketMaxima[bucketIndex] == Integer.MIN_VALUE ? A.get(i)
					: Math.max(bucketMaxima[bucketIndex], A.get(i));
			bucketMinima[bucketIndex] = bucketMinima[bucketIndex] == Integer.MAX_VALUE ? A.get(i)
					: Math.min(bucketMinima[bucketIndex], A.get(i));
		}
		int prev = min;
		int maxGap = 0;
		for (int i = 0; i < (n - 1); i++) {
			// empty bucket according to Pigeonhole principle
			if (bucketMinima[i] == Integer.MAX_VALUE) {
				continue;
			}

			maxGap = Math.max(maxGap, bucketMinima[i] - prev);
			prev = bucketMaxima[i];
		}

		maxGap = Math.max(maxGap, max - prev);

		return maxGap;

	}

	class Bucket {
		int low;
		int high;

		public Bucket() {
			this.low = -1;
			this.high = -1;
		}
	}

	// DO NOT MODIFY THE LIST
	public int maximumGapBucket(final List<Integer> a) {

		final int[] num = new int[a.size()];
		for (int i = 0; i < num.length; i++) {
			num[i] = a.get(i);
		}

		if ((num == null) || (num.length < 2)) {
			return 0;
		}

		int max = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		// initialize an array of buckets
		final Bucket[] buckets = new Bucket[num.length + 1]; // project to (0 - n)
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}

		final double interval = (double) num.length / (max - min);
		// distribute every number to a bucket array
		for (int i = 0; i < num.length; i++) {
			final int index = (int) ((num[i] - min) * interval);

			if (buckets[index].low == -1) {
				buckets[index].low = num[i];
				buckets[index].high = num[i];
			} else {
				buckets[index].low = Math.min(buckets[index].low, num[i]);
				buckets[index].high = Math.max(buckets[index].high, num[i]);
			}
		}

		// scan buckets to find maximum gap
		int result = 0;
		int prev = buckets[0].high;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].low != -1) {
				result = Math.max(result, buckets[i].low - prev);
				prev = buckets[i].high;
			}

		}

		return result;
	}

	public static void main(final String[] args) {
	}

}
