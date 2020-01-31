package com.interviewbit.graph.traversal;

import java.util.ArrayList;

public class WordSearchBoard {
    public int exist(ArrayList<String> A, String B) {
        int rows = A.size();
        int cols = A.get(0).length();
        boolean[][] visited = new boolean[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (A.get(x).charAt(y) == B.charAt(0)) {
                    if (findmatch(A, B, x, y, rows, cols, 0, visited)) return 1;
                }
            }
        }
        return 0;
    }

    private boolean findmatch(final ArrayList<String> A, final String B, final int x, final int y, final int rows, final int cols, final int level, final boolean[][] visited) {
        int l = B.length();
        if (level == l) return true;
        if (x < 0 || y < 0 || x >= rows || y >= cols) return false;
        if (A.get(x).charAt(y) == B.charAt(level)) {
            visited[x][y] = true;
            boolean res = findmatch(A, B, x - 1, y, rows, cols, level + 1, visited) | findmatch(A, B, x + 1, y, rows, cols, level + 1, visited) | findmatch(A, B, x, y - 1, rows, cols, level + 1, visited) | findmatch(A, B, x, y + 1, rows, cols, level + 1, visited);
            visited[x][y] = false;
            return res;
        }
        else {
            return false;
        }

    }
}