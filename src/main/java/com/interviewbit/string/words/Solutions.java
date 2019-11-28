package com.interviewbit.string.words;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solutions {
	public int lengthOfLastWord(final String A) {
		final String A1 = A.trim();
		if (A1.contains(" ") && (A1.length() > 1)) {
			final int i = A1.lastIndexOf(" ");
			return (A1.length() - 1) - i;
		} else {
			return A1.length();
		}
	}

	public String solve(final String A) {
		final List<String> words = Arrays.stream(A.split(" "))
				// wipe out all remaining spaces
				.map(String::trim)
				// filter out empty strings
				.filter(s -> !s.isEmpty()).collect(Collectors.toList());

		// reverse List and join with a space
		Collections.reverse(words);
		return String.join(" ", words);
	}
}
