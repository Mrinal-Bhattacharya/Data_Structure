package com.java.dp;

public class MaximumSizeSquareSubMatrix {
	int solution(final int[][] M) {
		final int rows = M.length;
		final int columns = M[0].length;
		final int[][] S = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			S[i][0] = M[i][0];
		}
		for (int i = 0; i < columns; i++) {
			S[0][i] = M[0][i];
		}
		for (int row = 1; row < rows; row++) {
			for (int column = 1; column < columns; column++) {
				if (M[row][column] == 0) {
					S[row][column] = 0;
				} else {
					S[row][column] = this.min(S[row][column - 1], S[row - 1][column], S[row - 1][column - 1]) + 1;
				}
			}
		}
		// Finding maxvalue
		int max = S[0][0];
		int max_row = 0, max_column = 0;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (S[row][column] > max) {
					max = S[row][column];
					max_row = row;
					max_column = column;
				}
			}
		}
		System.out.println(max_row + " " + max_column);
		for (int i = max_row; i > (max_row - max); i--) {
			for (int j = max_column; j > (max_column - max); j--) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();

		}
		return max;
	}

	int min(final int x, final int y, final int z) {
		if ((x <= y) && (x <= z)) {
			return x;
		}
		if ((y <= x) && (y <= z)) {
			return y;
		} else {
			return z;
		}
	}

	// Driver program
	public static void main(final String[] args) {
		final int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		System.out.println(new MaximumSizeSquareSubMatrix().solution(M));
	}
}