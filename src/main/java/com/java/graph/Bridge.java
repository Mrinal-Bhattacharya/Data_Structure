package com.java.graph;

import java.util.List;

public class Bridge {
	int time = 0;

	public static void main(final String[] args) {
		System.out.println("Bridges in first graph ");
		final Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(2, 1);
		g1.addEdge(1, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 0);
		g1.addEdge(3, 4);
		g1.addEdge(4, 3);
		new Bridge().bridge(g1);
		System.out.println();

		System.out.println("Bridges in Second graph");
		final Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 0);
		g2.addEdge(1, 2);
		g2.addEdge(2, 1);
		g2.addEdge(2, 3);
		g2.addEdge(3, 2);
		new Bridge().bridge(g2);
		System.out.println();

		System.out.println("Bridges in Third graph ");
		final Graph g3 = new Graph(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 0);
		g3.addEdge(1, 2);
		g3.addEdge(2, 1);
		g3.addEdge(2, 0);
		g3.addEdge(0, 2);
		g3.addEdge(1, 3);
		g3.addEdge(3, 1);
		g3.addEdge(1, 4);
		g3.addEdge(4, 1);
		g3.addEdge(1, 6);
		g3.addEdge(6, 1);
		g3.addEdge(3, 5);
		g3.addEdge(5, 3);
		g3.addEdge(4, 5);
		g3.addEdge(5, 4);
		new Bridge().bridge(g3);
	}

	private void bridge(final Graph graph) {
		final boolean[] visited = new boolean[graph.V];
		final int[] low = new int[graph.V];
		final int[] disc = new int[graph.V];
		final int[] parent = new int[graph.V];
		for (int i = 0; i < graph.V; i++) {
			if (!visited[i]) {
				this.bridgeUtil(i, visited, parent, disc, low, graph);
			}
		}

	}

	private void bridgeUtil(final int i, final boolean[] visited, final int[] parent, final int[] disc, final int[] low,
			final Graph graph) {
		visited[i] = true;
		disc[i] = low[i] = ++this.time;
		final List<Integer> children = graph.adj[i];
		for (final Integer child : children) {
			if (!visited[child]) {
				parent[child] = i;
				this.bridgeUtil(child, visited, parent, disc, low, graph);
				low[i] = Math.min(low[i], low[child]);
				if (low[child] > disc[i]) {
					System.out.println(i + " " + child);
				}
			} else if (child != parent[i]) {
				low[i] = Math.min(low[i], disc[child]);
			}
		}

	}
}
