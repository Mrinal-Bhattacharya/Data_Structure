package com.interviewbit.graph.connectivity;

import com.java.graph.Graph;

import java.util.List;

public class CyclicWithStack {
    public static void main(final String[] args) {
        final Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        if (isCyclic(graph)) {
            System.out.println("cyclic");
        }
        else {
            System.out.println("Non cyclic");
        }
    }

    private static boolean isCyclic(final Graph graph) {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        final boolean[] visited = new boolean[4];
        final boolean[] recStack = new boolean[4];
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < 4; i++) {
            if (isCyclicUtil(i, visited, recStack, graph)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isCyclicUtil(final int i, final boolean[] visited, final boolean[] recStack, final Graph graph) {
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;

        final List<Integer> children = graph.adj[i];
        for (final Integer c : children) {
            if (isCyclicUtil(c, visited, recStack, graph)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}
