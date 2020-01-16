package com.interviewbit.array.bucketing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutions {

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
