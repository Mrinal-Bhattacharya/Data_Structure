package com.java.graph;

import java.util.Iterator;
import java.util.List;

public class Cyclic {
	static int WHITE = 0, GRAY = 1, BLACK = 2;

	public static void main(final String[] args) {
		final Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		if (Cyclic.isCyclic(graph)) {
			System.out.println("cyclic");
		} else {
			System.out.println("Non cyclic");
		}
		if (Cyclic.isCyclicColor(graph)) {
			System.out.println("cyclic");
		} else {
			System.out.println("Non cyclic");
		}

		CyclicGraph.unionAndFind();

		CyclicGraph.cyclicWithParent();

		CyclicGraph.isTree();
	}

	private static boolean isCyclic(final Graph graph) {
		// Mark all the vertices as not visited and
		// not part of recursion stack
		final boolean[] visited = new boolean[4];
		final boolean[] recStack = new boolean[4];
		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < 4; i++) {
			if (Cyclic.isCyclicUtil(i, visited, recStack, graph)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isCyclicUtil(final int i, final boolean[] visited, final boolean[] recStack,
			final Graph graph) {
		// TODO Auto-generated method stub
		if (recStack[i]) {
			return true;
		}
		if (visited[i]) {
			return false;
		}
		visited[i] = true;
		recStack[i] = true;

		final List<Integer> children = graph.adj[i];
		for (final Integer c : children) {
			if (Cyclic.isCyclicUtil(c, visited, recStack, graph)) {
				return true;
			}
		}
		recStack[i] = false;
		return false;
	}

	// Returns true if there is a cycle in graph
	static boolean isCyclicColor(final Graph g) {
		// Initialize color of all vertices as WHITE
		final int[] color = new int[g.V];
		for (int i = 0; i < g.V; i++) {
			color[i] = Cyclic.WHITE;
		}

		// Do a DFS traversal beginning with all
		// vertices
		for (int i = 0; i < g.V; i++) {
			if (color[i] == Cyclic.WHITE) {
				if (Cyclic.isCyclicColorUtil(g, i, color) == true) {
					return true;
				}
			}
		}
		return false;

	}

	private static boolean isCyclicColorUtil(final Graph g, final int u, final int[] color) {
		// GRAY : This vertex is being processed (DFS
		// for this vertex has started, but not
		// ended (or this vertex is in function
		// call stack)
		color[u] = Cyclic.GRAY;

		// Iterate through all adjacent vertices
		for (final Integer in : g.adj[u]) {
			// If there is
			if (color[in] == Cyclic.GRAY) {
				return true;
			}

			// If v is not processed and there is a back
			// edge in subtree rooted with v
			if ((color[in] == Cyclic.WHITE) && (Cyclic.isCyclicColorUtil(g, in, color) == true)) {
				return true;
			}
		}

		// Mark this vertex as processed
		color[u] = Cyclic.BLACK;
		return false;
	}

}

class CyclicGraph {
	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // /collection of all edges

	class Edge {
		int src, dest;
	};

	// Creates a graph with V vertices and E edges
	CyclicGraph(final int v, final int e) {
		this.V = v;
		this.E = e;
		this.edge = new Edge[this.E];
		for (int i = 0; i < e; ++i) {
			this.edge[i] = new Edge();
		}
	}

	public static void isTree() {
		// Create a graph given in the above diagram
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 0);
		g1.addEdge(3, 4);
		g1.addEdge(4, 3);
		CyclicGraph.isTree(g1);
		g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		CyclicGraph.isTree(g1);
	}

	public static void cyclicWithParent() {
		// Create a graph given in the above diagram
		final Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (CyclicGraph.isCyclic(g1)) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contains cycle");
		}
		final Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (CyclicGraph.isCyclic(g2)) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contains cycle");
		}
	}

	public static void unionAndFind() {
		final int V = 3, E = 3;
		final CyclicGraph graph = new CyclicGraph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1) {
			System.out.println("graph contains cycle");
		} else {
			System.out.println("graph doesn't contain cycle");
		}
	}

	private int isCycle(final CyclicGraph graph) {
		final int[] parent = new int[graph.V];
		for (int i = 0; i < graph.V; ++i) {
			parent[i] = -1;
		}
		for (int i = 0; i < graph.E; ++i) {
			final int x = this.find(parent, graph.edge[i].src);
			final int y = this.find(parent, graph.edge[i].dest);
			if (x == y) {
				return 1;
			}

			this.union(parent, x, y);
		}
		return 0;
	}

	private void union(final int[] parent, final int x, final int y) {
		final int xset = this.find(parent, x);
		final int yset = this.find(parent, y);
		parent[xset] = yset;
	}

	private int find(final int[] parent, final int i) {
		if (parent[i] == -1) {
			return i;
		}
		return this.find(parent, parent[i]);
	}

	// Returns true if the graph contains a cycle, else false.
	static Boolean isCyclic(final Graph graph) {
		// Mark all the vertices as not visited and not part of
		// recursion stack
		final Boolean visited[] = new Boolean[5];
		for (int i = 0; i < graph.V; i++) {
			visited[i] = false;
		}

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < graph.V; u++) {
			if (!visited[u]) {
				if (CyclicGraph.isCyclicUtil(u, visited, -1, graph)) {
					return true;
				}
			}
		}

		return false;
	}

	static void isTree(final Graph g) {
		// 1) There is no cycle.
		// 2) The graph is connected.
		final Boolean visited[] = new Boolean[5];
		for (int i = 0; i < g.V; i++) {
			visited[i] = false;
		}
		if (CyclicGraph.isCyclicUtil(0, visited, -1, g)) {
			System.out.println("Not a tree becuase there is cyclic in graph");
			return;
		}
		for (int i = 0; i < g.V; i++) {
			if (!visited[i]) {
				System.out.println("Not a tree becuase Not a connected graph");
				return;
			}
		}
		System.out.println("Is a Tree");

	}

	private static boolean isCyclicUtil(final int v, final Boolean[] visited, final int parent, final Graph graph) {
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this vertex
		final Iterator<Integer> it = graph.adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (CyclicGraph.isCyclicUtil(i, visited, v, graph)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}

}