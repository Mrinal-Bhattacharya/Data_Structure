package com.interviewbit.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(final ArrayList<Integer> A) {
        final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        if (A.size() == 0) {
            return output;
        }

        Collections.sort(A);
        this.subsetsWithDupHelper(A, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void subsetsWithDupHelper(final ArrayList<Integer> a, final ArrayList<ArrayList<Integer>> output,
                                     final ArrayList<Integer> temp, final int index) {
        for (int i = index; i < a.size(); i++) {
            temp.add(a.get(i));
            if (!output.contains(temp)) {
                output.add(new ArrayList<>(temp));
            }
            this.subsetsWithDupHelper(a, output, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
