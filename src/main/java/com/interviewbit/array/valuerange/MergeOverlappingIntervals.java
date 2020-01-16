package com.interviewbit.array.valuerange;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
	public ArrayList<Interval> merge(final ArrayList<Interval> intervals) {
		final ArrayList<Interval> output = new ArrayList<>();
		output.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= output.get(output.size() - 1).end) {
				output.get(output.size() - 1).end = Math.max(intervals.get(i).end, output.get(output.size() - 1).end);
			} else {
				output.add(intervals.get(i));
			}
		}
		return output;
	}
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */