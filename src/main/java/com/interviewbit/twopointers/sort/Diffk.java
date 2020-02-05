package com.interviewbit.twopointers.sort;

import java.util.ArrayList;

public class Diffk {
    public int diffPossible(final ArrayList<Integer> A, final int B) {
        int i = 0, j = 1;
        final int size = A.size();
        while ((i < size) && (j < size)) {
            if ((i != j) && ((A.get(j) - A.get(i)) == B)) {
                return 1;
            } else if ((A.get(j) - A.get(i)) < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }
}
