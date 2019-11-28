package com.interviewbit.backtracking.gamesolving;

import java.util.ArrayList;

public class Solutions {
	public ArrayList<ArrayList<String>> solveNQueens(final int a) {
		final String board[][] = new String[a][a];
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

	boolean isSafe(final String board[][], final int a, final int row, final int col) {
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

	public void solveSudoku(final ArrayList<ArrayList<Character>> a) {
		final int n = a.size();
		final int bd[][] = new int[n][n];
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

	public static void main(final String args[]) throws Exception {
		final Solutions nq = new Solutions();
		System.out.println(nq.solveNQueens(4));
	}
}
