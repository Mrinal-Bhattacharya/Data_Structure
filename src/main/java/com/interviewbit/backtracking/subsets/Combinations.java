package com.interviewbit.backtracking.subsets;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(final int A, final int B) {
        final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A < B) {
            return ans;
        }

        final ArrayList<Integer> temp = new ArrayList<>();
        this.combineHelper(A, B, ans, temp, 1);
        return ans;
    }

    private void combineHelper(final int a, final int b, final ArrayList<ArrayList<Integer>> ans,
                               final ArrayList<Integer> temp, final int start) {
        // this block is just for performance improvement, we can remove this if block
        if (temp.size() > b) {
            return;
        }
        if ((temp.size() == b)) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = start; i <= a; i++) {
            if (temp.contains(i)) {
                continue;
            }
            // Choose
            temp.add(i);
            // Explore
            this.combineHelper(a, b, ans, temp, i + 1);
            // Un-choose
            temp.remove(temp.size() - 1);
        }
    }

}
