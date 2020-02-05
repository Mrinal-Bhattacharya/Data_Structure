package com.interviewbit.hash.keyformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        final HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        final int n = a.size();
        new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final char[] arr = a.get(i).toCharArray();
            Arrays.sort(arr);
            final String str = new String(arr);
            if (map.get(str) != null) {
                map.get(str).add(i + 1);
            } else {
                final ArrayList<Integer> g = new ArrayList<>();
                g.add(i + 1);
                map.put(str, g);
            }
        }

        for (final ArrayList<Integer> l : map.values()) {
            result.add(l);
        }
        return result;
    }
}
