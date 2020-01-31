package com.interviewbit.graph.connectivity;

import java.util.ArrayList;

public class CaptureRegionsOnBoard {
    public void solve(ArrayList<ArrayList<Character>> a) {
        int rows = a.size();
        int cols = a.get(0).size();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (a.get(i).get(j) == 'O') a.get(i).set(j, '-');
        for (int i = 0; i < rows; i++) // Left side
            if (a.get(i).get(0) == '-') floodFillUtil(a, i, 0, '-', 'O');
        for (int i = 0; i < rows; i++) // Right side
            if (a.get(i).get(cols - 1) == '-') floodFillUtil(a, i, cols - 1, '-', 'O');
        for (int i = 0; i < cols; i++) // Top side
            if (a.get(0).get(i) == '-') floodFillUtil(a, 0, i, '-', 'O');
        for (int i = 0; i < cols; i++) // Bottom side
            if (a.get(rows - 1).get(i) == '-') floodFillUtil(a, rows - 1, i, '-', 'O');
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (a.get(i).get(j) == '-') a.get(i).set(j, 'X');
    }

    private void floodFillUtil(ArrayList<ArrayList<Character>> a, int x, int y, char prevV, char newV) {
        // Base cases
        if (x < 0 || x >= a.size() || y < 0 || y >= a.get(0).size()) return;
        if (a.get(x).get(y) != prevV) return;
        // Replace the color at (x, y)
        a.get(x).set(y, newV);
        // Recur for north,
        // east, south and west
        floodFillUtil(a, x + 1, y, prevV, newV);
        floodFillUtil(a, x - 1, y, prevV, newV);
        floodFillUtil(a, x, y + 1, prevV, newV);
        floodFillUtil(a, x, y - 1, prevV, newV);
    }


}
