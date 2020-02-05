package com.interviewbit.twopointers.multiplearrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = 0;
        final ArrayList<Integer> ans = new ArrayList<>();
        while ((i < A.size()) && (j < B.size())) {
            if (A.get(i).equals(B.get(j))) {
                ans.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
