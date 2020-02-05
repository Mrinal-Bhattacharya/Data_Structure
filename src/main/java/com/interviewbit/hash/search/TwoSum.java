package com.interviewbit.hash.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, final int B) {
        final ArrayList<Integer> ans = new ArrayList<>();

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                ans.add(map.get(B - A.get(i)));
                ans.add(i + 1);
                break;
            } else if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i + 1);
            }
        }

        return ans;
    }
}
