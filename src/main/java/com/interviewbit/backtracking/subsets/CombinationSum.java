package com.interviewbit.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(final ArrayList<Integer> A, final int B) {
        final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A.size() == 0) {
            return ans;
        }

        Collections.sort(A);
        final ArrayList<Integer> temp = new ArrayList<>();
        this.combinationSumHelper(A, B, ans, temp, 0);

        return ans;
    }

    private void combinationSumHelper(final ArrayList<Integer> a, final int b, final ArrayList<ArrayList<Integer>> ans,
                                      final ArrayList<Integer> temp, final int start) {
        if (b < 0) {
            return;
        }
        if ((b == 0) && !ans.contains(temp)) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < a.size(); i++) {
                // Choose
                temp.add(a.get(i));
                // Explore
                this.combinationSumHelper(a, b - a.get(i), ans, temp, i);
                // Un-choose
                temp.remove(temp.size() - 1);
            }
        }
    }
}
