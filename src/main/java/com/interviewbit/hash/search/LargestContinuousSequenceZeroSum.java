package com.interviewbit.hash.search;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public ArrayList<Integer> lszero(final ArrayList<Integer> a) {
        int start = 0, end = 0;
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if (map.containsKey(sum)) {
                final int currStart = map.get(sum), currEnd = i;
                if (((currEnd - currStart) + 1) > ((end - start) + 1)) {
                    start = currStart;
                    end = currEnd;
                }
            } else {
                map.put(sum, i);
            }
        }
        // System.out.println(map);

        final ArrayList<Integer> result = new ArrayList<>();
        for (int i = start + 1; i <= end; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}
