package com.interviewbit.heapandmap.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(final ArrayList<Integer> A, final int B) {
        final ArrayList<Integer> ans = new ArrayList<>();
        if (B > A.size()) {
            return ans;
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }

        ans.add(map.size());

        for (int i = B; i < A.size(); i++) {
            map.put(A.get(i - B), map.get(A.get(i - B)) - 1);
            if (map.get(A.get(i - B)) == 0) {
                map.remove(A.get(i - B));
            }

            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);

            ans.add(map.size());
        }

        return ans;
    }
}
