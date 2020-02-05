package com.interviewbit.backtracking.gamesolving;

import java.util.ArrayList;

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(final int a) {
        final String[][] board = new String[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                board[i][j] = ".";
            }
        }
        final ArrayList<ArrayList<String>> result = new ArrayList<>();
        this.solveNQueensUtil(board, a, 0, result);
        return result;
    }
    private void solveNQueensUtil(final String[][] board, final int a, final int col,
                                  final ArrayList<ArrayList<String>> result) {
        if (col == a) {
            final ArrayList<String> sol = new ArrayList<>();
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    sb.append(board[i][j]);
                }
                sol.add(sb.toString());
                sb.delete(0, sb.length());
            }
            result.add(sol);
            return;
        }
        for (int row = 0; row < a; row++) {
            if (this.isSafe(board, a, row, col)) {
                board[row][col] = "Q";
                // Make result true if any placement
                // is possible
                this.solveNQueensUtil(board, a, col + 1, result);
                /*
                 * If placing queen in board[i][col] doesn't lead to a solution, then remove
                 * queen from board[i][col]
                 */
                board[row][col] = "."; // BACKTRACK
            }
        }
    }

    private boolean isSafe(final String[][] board, final int a, final int row, final int col) {
        int i, j;
        /* Check this row on left side */
        for (i = 0; i < col; i++) {
            if (board[row][i].equals("Q")) {
                return false;
            }
        }
        /* Check upper diagonal on left side */
        for (i = row, j = col; (i >= 0) && (j >= 0); i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        /* Check lower diagonal on left side */
        for (i = row, j = col; (j >= 0) && (i < a); i++, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }
}
