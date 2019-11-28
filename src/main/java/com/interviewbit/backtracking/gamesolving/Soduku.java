package com.interviewbit.backtracking.gamesolving;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Soduku {

	int n = 9;
	int bd[][] = new int[this.n][this.n];

	public void solveSudoku(final ArrayList<ArrayList<Character>> a) {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (a.get(i).get(j) == '.') {
					this.bd[i][j] = 0;
					continue;
				}
				this.bd[i][j] = Character.getNumericValue(a.get(i).get(j));
			}
		}

		this.solve(0, 0);

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				final char c = (char) (this.bd[i][j] + '0');
				a.get(i).set(j, c);
			}
		}
	}

	private boolean solve(final int row, final int col) {
		if (row == this.n) {
			return true;
		}
		if (col == this.n) {
			return this.solve(row + 1, 0);
		}
		if (this.bd[row][col] != 0) {
			return this.solve(row, col + 1);
		}

		for (int i = 1; i < 10; i++) {
			if (this.isValid(i, row, col)) {
				this.bd[row][col] = i;
				if (this.solve(row, col + 1)) {
					return true;
				}
				this.bd[row][col] = 0;
			}
		}
		return false;
	}

	private boolean isValid(final int val, int row, int col) {
		for (int j = 0; j < this.n; j++) {
			if (this.bd[row][j] == val) {
				return false;
			}
		}

		for (int i = 0; i < this.n; i++) {
			if (this.bd[i][col] == val) {
				return false;
			}
		}

		row = (row / 3) * 3;
		col = (col / 3) * 3;
		for (int i = row; i < (row + 3); i++) {
			for (int j = col; j < (col + 3); j++) {
				if (this.bd[i][j] == val) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(final String[] args) {
		final String[] sudokuString = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6",
				".6....28.", "...419..5", "....8..79" };
		final ArrayList<ArrayList<Character>> a = new ArrayList<>();
		for (final String aSudokuString : sudokuString) {
			a.add(Soduku.getAsCharArray(aSudokuString));
		}
		new Soduku().solveSudoku(a);
		System.out.println(a);
	}

	private static ArrayList<Character> getAsCharArray(final String s) {
		return IntStream.range(0, s.length()).mapToObj(s::charAt).collect(Collectors.toCollection(ArrayList::new));
	}
}