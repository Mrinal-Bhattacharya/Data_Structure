package com.interviewbit.graph.shortestpath;

import java.util.*;

public class WordLadder1 {
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

        System.out.println(new WordLadder1().solve(start, end, dictV));
    }

    public int solve(String start, String end, ArrayList<String> dictV) {
        Map<String, Node> words = new HashMap<>();
        for (String s : dictV) {
            words.put(s, new Node(s));
        }

        for (int i = 0; i < dictV.size(); i++) {
            for (int j = i + 1; j < dictV.size(); j++) {
                String s1 = dictV.get(i);
                String s2 = dictV.get(j);
                if (isOneEditApart(s1, s2)) {
                    words.get(s1).neighbors.add(words.get(s2));
                    words.get(s2).neighbors.add(words.get(s1));
                }
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        Deque<Integer> depthQueue = new ArrayDeque<>();

        Set<String> visited = new HashSet<>();
        queue.addLast(words.get(start));
        depthQueue.addLast(1);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.removeFirst();
            int depth = depthQueue.removeFirst();
            if (cur.word.equals(end)) {
                return depth;
            }
            for (Node neighbor : cur.neighbors) {
                if (!visited.contains(neighbor.word)) {
                    queue.addLast(neighbor);
                    depthQueue.addLast(depth + 1);
                    visited.add(neighbor.word);
                }
            }
        }

        return 0;
    }

    private boolean isOneEditApart(String s1, String s2) {
        boolean edit = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (edit) return false;
                edit = true;
            }
        }
        return edit;
    }

    public static class Node {
        String word;
        List<Node> neighbors;

        public Node(String word) {
            this.word = word;
            neighbors = new ArrayList<>();
        }
    }
}