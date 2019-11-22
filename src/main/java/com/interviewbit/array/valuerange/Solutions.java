package com.interviewbit.array.valuerange;

import java.util.ArrayList;
import java.util.Comparator;

public class Solutions {
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
				output.get(output.size() - 1).end = Math.max(intervals.get(i).end, output.get(output.size() - 1).end);
			} else {
				output.add(intervals.get(i));
			}
		}
		return output;
	}

	public static void main(final String[] args) {
		final Interval newInterval = new Interval(4, 9);
		final ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 6));

		// [1,2],[3,5],[6,7],[8,10],[12,16]
		final ArrayList<Interval> insert = new Solutions().insert(intervals, newInterval);
		System.out.println(insert);
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