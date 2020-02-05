package com.interviewbit.twopointers.inplaceupdate;

import java.util.ArrayList;

public class RemoveElementFromArray {
    public int removeElement(final ArrayList<Integer> a, final int b) {
        final int n = a.size();
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (a.get(j) != b) {
                a.set(i, a.get(j));
                i++;
            }
        }
        return i;
    }
}
