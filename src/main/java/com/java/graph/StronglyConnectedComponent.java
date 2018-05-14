package com.java.graph;

import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponent {
	public static void main(final String[] args) {
		final Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components " + "in given graph ");
		new StronglyConnectedComponent().printSCCs(5, g);
	}

	void printSCCs(final int V, final Graph graph) {
		final Stack stack = new Stack();

		// Mark all the vertices as not visited (For first DFS)
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				this.fillOrder(i, visited, graph, stack);
			}
		}
		final Graph g = this.getTranspose(V, graph);
		visited = new boolean[V];
		while (stack.empty() == false) {
			// Pop a vertex from stack
			final int v = (int) stack.pop();

			// Print Strongly connected component of the popped vertex
			if (visited[v] == false) {
				g.DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	private void fillOrder(final int v, final boolean[] visited, final Graph graph, final Stack stack) {
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		final Iterator<Integer> i = graph.adj[v].iterator();
		while (i.hasNext()) {
			final int n = i.next();
			if (!visited[n]) {
				this.fillOrder(n, visited, graph, stack);
			}
		}
		// All vertices reachable from v are processed by now,
		// push v to Stack
		stack.push(new Integer(v));

	}

	// Function that returns reverse (or transpose) of this graph
	Graph getTranspose(final int V, final Graph graph) {
		final Graph g = new Graph(V);
		for (int v = 0; v < V; v++) {
			// Recur for all the vertices adjacent to this vertex
			final Iterator<Integer> i = graph.adj[v].listIterator();
			while (i.hasNext()) {
				g.adj[i.next()].add(v);
			}
		}
		return g;
	}

}
