package com.interviewbit.math.adhoc;

import java.util.ArrayList;

public class FizzBuzz {
	public ArrayList<String> fizzBuzz(final int A) {
		final ArrayList<String> output = new ArrayList<>();
		for (int i = 1; i <= A; i++) {
			if (((i % 3) == 0) && ((i % 5) == 0)) {
				output.add("FizzBuzz");
				continue;
			}
			if ((i % 3) == 0) {
				output.add("Fizz");
				continue;
			}
			if ((i % 5) == 0) {
				output.add("Buzz");
				continue;
			}
			output.add("" + i);
		}
		return output;
	}
}
