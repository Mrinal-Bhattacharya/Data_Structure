package com.interviewbit.graph.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class WordLadder2 {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>();
        dictV.add("hot");
        dictV.add("dot");
        dictV.add("dog");
        dictV.add("lot");
        dictV.add("log");
        dictV.add("hit");
        dictV.add("cog");

        System.out.println(new WordLadder2().findLadders(start, end, dictV));
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV) {
        List<String> dict = dictV.stream().distinct().collect(Collectors.toList());
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> init = new ArrayList<>();
        init.add(start);
        q.add(init);

        while (!q.isEmpty()) {
            init = q.poll();
            String test = init.get(init.size() - 1);
            if (test.equals(end)) {
                if (!ans.contains(init)) ans.add(init);
                continue;
            }
            if (isValid(test, end)) {
                init.add(end);
                if (!ans.contains(init)) ans.add(init);
                continue;
            }
            for (int i = 0; i < dict.size(); i++) {
                if (isValid(test, dict.get(i)) && !init.contains(dict.get(i))) {
                    ArrayList<String> n = new ArrayList<>(init);
                    n.add(dict.get(i));
                    q.add(n);
                }
            }
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++)
            minLength = Math.min(minLength, ans.get(i).size());
        for (int i = ans.size() - 1; i >= 0; i--) {
            if (ans.get(i).size() != minLength) ans.remove(i);
        }
        return ans;
    }

    private boolean isValid(String a, String b) {
        boolean edit = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (edit) return false;
                edit = true;
            }
        }
        return edit;
    }
}