package com.interviewbit.graph.connectivity;

import java.util.ArrayList;

public class BlackShapes {
    public int black(ArrayList<String> A) {
        int n = A.size();
        int k = A.get(0).length();
        boolean visited[][] = new boolean[n][k];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (A.get(i).charAt(j) == 'X' && !visited[i][j]) {
                    DFS(visited, A, i, j, n, k);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(final boolean[][] visited, final ArrayList<String> A, final int i, final int j, final int n, final int k) {
        if (A.get(i).charAt(j) == 'X' && !visited[i][j]) {
            visited[i][j] = true;
            if (i + 1 < n) DFS(visited, A, i + 1, j, n, k);
            if (i - 1 >= 0) DFS(visited, A, i - 1, j, n, k);
            if (j + 1 < k) DFS(visited, A, i, j + 1, n, k);
            if (j - 1 >= 0) DFS(visited, A, i, j - 1, n, k);
        }
        else return;
    }
}
