package com.interviewbit.graph.connectivity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {
    public int solve(int A, List<Integer> B, List<Integer> C) {
        int V = A;
        int E = B.size();
        final boolean[] visited = new boolean[V];
        final boolean[] recStack = new boolean[V];
        final List<Integer> adj[] = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < E; i++) {
            adj[B.get(i) - 1].add(C.get(i) - 1);
        }
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, adj)) return 0;
        return 1;
    }
    private static boolean isCyclicUtil(final int v, final boolean[] visited, final boolean[] recStack, List<Integer>[] adj) {
        if (visited[v] == false) {
            visited[v] = true;
            recStack[v] = true;
            for (int a : adj[v]) {
                if (!visited[a] && isCyclicUtil(a, visited, recStack, adj)) return true;
                else if (recStack[a]) return true;
            }
        }
        recStack[v] = false;
        return false;
    }

}
