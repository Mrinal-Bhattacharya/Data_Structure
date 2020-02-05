package com.interviewbit.twopointers.multiplearrays;

import java.util.ArrayList;

public class MergeTwoSortedListsII {
    public void merge(final ArrayList<Integer> a, final ArrayList<Integer> b) {
        final int m = a.size();
        final int n = b.size();
        int i = 0, j = 0;
        while ((i < m) && (j < n)) {
            if (a.get(i) <= b.get(j)) {
                i++;
            } else {
                a.add(i, b.get(j));
                j++;
            }
        }
        while (j < n) {
            a.add(i, b.get(j));
            j++;
        }
    }
}
