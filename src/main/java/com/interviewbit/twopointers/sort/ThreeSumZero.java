package com.interviewbit.twopointers.sort;

import java.util.*;

public class ThreeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(final ArrayList<Integer> A) {
        Collections.sort(A);
        this.removeDuplicates(A);
        final ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < (A.size() - 2); i++) {
            int start = i + 1;
            int end = A.size() - 1;
            while (start < end) {
                if ((A.get(i) + A.get(start) + A.get(end)) == 0) {
                    arr = new ArrayList<>();
                    arr.add(A.get(i));
                    arr.add(A.get(start));
                    arr.add(A.get(end));
                    ans.add(arr);
                    start++;
                    end--;
                } else if ((A.get(i) + A.get(start) + A.get(end)) < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;

    }

    public int removeDuplicates(final ArrayList<Integer> a) {
        if (a.size() <= 1) {
            return a.size();
        }
        int i = 1;
        int j = 1;
        while (i < a.size()) {
            if (!a.get(i).equals(a.get(i - 1))) {
                a.set(j, a.get(i));
                j++;
            }
            i++;
        }
        final ArrayList<Integer> itemsToKeep = new ArrayList<>();
        i = 0;
        while (i < j) {
            itemsToKeep.add(a.get(i++));
        }
        a.clear();
        for (final int num : itemsToKeep) {
            a.add(num);
        }
        return a.size();
    }
}
