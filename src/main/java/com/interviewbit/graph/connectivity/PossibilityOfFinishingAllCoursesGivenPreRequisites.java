package com.interviewbit.graph.connectivity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {
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

    public static void main(String[] args) {
        int A = 70;
        Integer[] B = {67, 8, 48, 42, 35, 25, 37, 69, 31, 36, 7, 33, 2, 47, 42, 52, 31, 70, 29, 38, 36, 60, 15, 37, 33, 27, 4, 32, 43, 55, 49, 35, 21, 28, 62, 17, 2, 61, 54, 22, 9, 56, 12, 3, 60, 52, 21, 15, 54, 63, 33, 64, 38, 16, 59, 69, 49, 52, 10, 10, 6, 56, 43, 32, 41, 66, 6};
        Integer[] C = {51, 43, 55, 27, 34, 8, 14, 5, 70, 64, 65, 57, 45, 19, 53, 50, 44, 51, 19, 41, 14, 68, 12, 58, 50, 66, 7, 47, 40, 62, 29, 5, 22, 39, 23, 34, 25, 4, 40, 26, 26, 45, 18, 28, 61, 59, 17, 46, 39, 46, 68, 24, 63, 59, 67, 53, 9, 11, 3, 44, 24, 37, 13, 1, 65, 18, 48};
        new PossibilityOfFinishingAllCoursesGivenPreRequisites().solve(A, Arrays.asList(B), Arrays.asList(C));
    }

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
}
