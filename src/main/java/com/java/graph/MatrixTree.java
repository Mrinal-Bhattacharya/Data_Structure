package com.java.graph;

public class MatrixTree {
	public static void main(final String[] args) {
		final int[][] adj = new int[4][4];
		adj[0][0] = 0;
		adj[0][1] = 0;
		adj[0][2] = 1;
		adj[0][3] = 1;

		adj[1][0] = 0;
		adj[1][1] = 0;
		adj[1][2] = 1;
		adj[1][3] = 1;

		adj[2][0] = 1;
		adj[2][1] = 1;
		adj[2][2] = 0;
		adj[2][3] = 1;

		adj[3][0] = 1;
		adj[3][1] = 1;
		adj[3][2] = 1;
		adj[3][3] = 0;

		final int[][] degree = MatrixTree.calculateDegree(adj);
		final int result = MatrixTree.cofactor(degree);

		System.out.println(result);
		final MatrixTree obj = new MatrixTree();
        final int[][] graph = {{0, 1, 1, 0}, {1, 0, 1, 1}, {1, 1, 0, 1}, {0, 1, 1, 0}};

		System.out.println("Total number of Triangle in Graph : " + obj.triangleInGraph(graph));
	}

	private static int cofactor(final int[][] degree) {
		final int result = ((degree[1][1] * degree[2][2] * degree[3][3]) + (degree[1][2] * degree[2][3] * degree[3][1])
				+ (degree[1][3] * degree[2][1] * degree[3][2])) - (degree[1][3] * degree[2][2] * degree[3][1])
				- (degree[1][2] * degree[2][1] * degree[3][3]) - (degree[1][1] * degree[2][3] * degree[3][2]);
		return result;
	}

	private static int[][] calculateDegree(final int[][] adj) {
		final int[][] degree = new int[4][4];
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				degree[row][col] = -1;
			}
		}
		for (int row = 0; row < 4; row++) {
			int sum = 0;
			for (int col = 0; col < 4; col++) {
				sum += adj[row][col];
			}
			degree[row][row] = sum;
		}
		return degree;
	}

    int triangleInGraph(final int[][] graph) {
		final int[][] aux2 = new int[4][4];
		final int[][] aux3 = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				aux2[i][j] = aux3[i][j] = 0;
			}
		}
		this.multiply(graph, graph, aux2);
		this.multiply(graph, aux2, aux3);
		final int trace = this.getTrace(aux3);
		return trace / 6;
	}

	private int getTrace(final int[][] graph) {
		int trace = 0;
		for (int i = 0; i < 4; i++) {
			trace += graph[i][i];
		}
		return trace;
	}

	private void multiply(final int[][] A, final int[][] B, final int[][] C) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				C[i][j] = 0;
				for (int k = 0; k < 4; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
}
