package com.interviewbit.string.words;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseTheString {
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
