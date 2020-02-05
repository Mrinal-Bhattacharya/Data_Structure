package com.interviewbit.backtracking.gamesolving;

import java.util.ArrayList;

public class NeedTOWork {


    public void solveSudoku(final ArrayList<ArrayList<Character>> a) {
        final int n = a.size();
        final int[][] bd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == '.') {
                    bd[i][j] = 0;
                    continue;
                }
                bd[i][j] = Character.getNumericValue(a.get(i).get(j));
            }
        }
        final int row = 0, col = 0;
        this.solveSudokuHelper(bd, n, row, col);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final char c = (char) (bd[i][j] + '0');
                a.get(i).set(j, c);
            }
        }
    }

    private boolean solveSudokuHelper(final int[][] bd, final int n, final int row, final int col) {
        if (row == n) {
            return true;
        }
        if (col == n) {
            return this.solveSudokuHelper(bd, n, row + 1, 0);
        }
        if (bd[row][col] != 0) {
            return this.solveSudokuHelper(bd, n, row, col + 1);
        }
        for (int i = 1; i < n; i++) {
            if (this.isValid(bd, i, row, col, n)) {
                bd[row][col] = i;
                if (this.solveSudokuHelper(bd, n, row, col + 1)) {
                    return true;
                }
                bd[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(final int[][] bd, final int val, int row, int col, final int n) {
        for (int j = 0; j < n; j++) {
            if (bd[row][j] == val) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (bd[i][col] == val) {
                return false;
            }
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for (int i = row; i < (row + 3); i++) {
            for (int j = col; j < (col + 3); j++) {
                if (bd[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}

