package com.interviewbit.hash.twopointer;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(final String A) {
        if (A == null) {
            return 0;
        }
        int res = 0;
        final HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            System.out.println("For Character :" + A.charAt(i) + " At i : " + i);
            if (!map.containsKey(A.charAt(i))) {
                System.out.println(" \t Put in the map");
                map.put(A.charAt(i), i);
            } else {
                System.out.println("\t update result and i");
                res = Math.max(res, map.size());
                i = map.get(A.charAt(i));
                System.out.println("i : " + i);
                map.clear();
            }
        }
        return Math.max(res, map.size());
    }
}
