package com.interviewbit.backtracking.bruteforcebuilder;

import java.util.*;

public class LetterPhone {
    public ArrayList<String> letterCombinations(final String A) {
        final Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        final ArrayList<String> ans = new ArrayList<>();
        this.letterCombinationsHelper(A, ans, map, new StringBuilder(), 0);
        return ans;
    }

    private void letterCombinationsHelper(final String a, final ArrayList<String> ans, final Map<Integer, String> map,
                                          final StringBuilder sb, final int id) {
        if (id > a.length()) {
            return;
        }
        if ((id == a.length()) && (sb.length() == a.length())) {
            ans.add(new StringBuilder(sb.toString()).toString());
        } else {
            for (int i = id; i < a.length(); i++) {
                final String mapping = map.get(Integer.valueOf(String.valueOf(a.charAt(i))));
                for (int j = 0; j < mapping.length(); j++) {
                    // Choose
                    sb.append(mapping.charAt(j));
                    // Explore
                    this.letterCombinationsHelper(a, ans, map, sb, i + 1);
                    // Un-choose
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    static ArrayList<String> letterCombinationsUtil(final int[] number, final int n, final String[] table) {
        final ArrayList<String> list = new ArrayList<>();
        final Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            final String s = q.remove();
            if (s.length() == n) {
                list.add(s);
            } else {
                final String val = table[number[s.length()]];
                for (int i = 0; i < val.length(); i++) {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }

    static void letterCombinations(final int[] number, final int n) {
        final String[] table = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        final ArrayList<String> list = letterCombinationsUtil(number, n, table);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
