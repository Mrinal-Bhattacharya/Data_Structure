package com.interviewbit.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(final ArrayList<Integer> A) {
        final ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        if (A.size() == 0) {
            return output;
        }

        Collections.sort(A);
        this.generate(A, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void generate(final ArrayList<Integer> a, final ArrayList<ArrayList<Integer>> output,
                         final ArrayList<Integer> temp, final int index) {
        for (int i = index; i < a.size(); i++) {
            temp.add(a.get(i));
            output.add(new ArrayList<>(temp));
            this.generate(a, output, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
