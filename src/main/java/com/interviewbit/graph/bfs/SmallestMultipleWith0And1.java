package com.interviewbit.graph.bfs;

import java.util.ArrayDeque;

public class SmallestMultipleWith0And1 {
    public static void main(String[] args) {
        int s1 = (1 * 10) % 55;
        int s2 = (1 * 10 + 1) % 55;
        System.out.println(s1 + " " + s2);
        new SmallestMultipleWith0And1().multiple(55);
    }

    public String multiple(int N) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node("1", 1 % N));
        boolean[] visited = new boolean[N];
        visited[1 % N] = true;
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.modN == 0) {
                return node.value;
            }


            int s1 = (node.modN * 10) % N;
            int s2 = (node.modN * 10 + 1) % N;

            if (!visited[s1]) {
                queue.addLast(new Node(node.value + "0", s1));
                visited[s1] = true;
            }

            if (!visited[s2]) {
                queue.addLast(new Node(node.value + "1", s2));
                visited[s2] = true;
            }
        }

        return "";
    }

    public static class Node {
        String value;
        int modN = -1;

        public Node(String x, int y) {
            value = x;
            modN = y;
        }
    }
}
