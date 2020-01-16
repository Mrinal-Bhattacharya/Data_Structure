package com.interviewbit.array.valuerange;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervals {
	/**
	 * Definition for an interval. public class Interval { int start; int end;
	 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
	 * e; } }
	 */
	public class Solution {
		public ArrayList<Interval> insert(final ArrayList<Interval> intervals, final Interval newInterval) {
			final ArrayList<Interval> output = new ArrayList<>();
			intervals.add(newInterval);
			intervals.sort(new Comparator<Interval>() {

				@Override
				public int compare(final Interval o1, final Interval o2) {
					return o1.start - o2.start;
				}

			});
			output.add(intervals.get(0));
			for (int i = 1; i < intervals.size(); i++) {
				if (intervals.get(i).start <= output.get(output.size() - 1).end) {
					output.get(output.size() - 1).end = Math.max(intervals.get(i).end,
							output.get(output.size() - 1).end);
				} else {
					output.add(intervals.get(i));
				}
			}
			return output;
		}
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	Interval(final int s, final int e) {
		this.start = s;
		this.end = e;
	}
}