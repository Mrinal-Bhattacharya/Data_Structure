package com.interviewbit.twopointers.tricks;

import java.util.List;

public class Array3Pointers {
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int diff = Integer.MAX_VALUE; // Initialize min diff
        final int size_a = A.size(), size_b = B.size(), size_c = C.size();
        int i = 0, j = 0, k = 0;
        while ((i < size_a) && (j < size_b) && (k < size_c)) {
            final int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            final int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            if ((maximum - minimum) < diff) {
                diff = maximum - minimum;
            }
            if (diff == 0) {
                break;
            }
            if (A.get(i) == minimum) {
                i++;
            } else if (B.get(j) == minimum) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }
}
