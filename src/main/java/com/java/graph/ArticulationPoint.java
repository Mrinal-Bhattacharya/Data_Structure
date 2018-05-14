package com.java.graph;

import java.util.Iterator;

// This class represents an undirected graph using adjacency list
// representation
class ArticulationPoint {

	private int time;
	static final int NIL = -1;
	private final Graph graph;

	public ArticulationPoint(final Graph graph) {
		this.graph = graph;
	}

	// A recursive function that find articulation points using DFS
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	// ap[] --> Store articulation points
	void APUtil(final int u, final boolean visited[], final int disc[], final int low[], final int parent[],
			final boolean ap[]) {

		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++this.time;

		// Go through all vertices aadjacent to this
		final Iterator<Integer> i = this.graph.adj[u].iterator();
		while (i.hasNext()) {
			final int v = i.next(); // v is current adjacent of u

			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v]) {
				children++;
				parent[v] = u;
				this.APUtil(v, visited, disc, low, parent, ap);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if ((parent[u] == ArticulationPoint.NIL) && (children > 1)) {
					ap[u] = true;
				}

				// (2) If u is not root and low value of one of its child
				// is more than discovery value of u.
				if ((parent[u] != ArticulationPoint.NIL) && (low[v] >= disc[u])) {
					ap[u] = true;
				}
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

	// The function to do DFS traversal. It uses recursive function APUtil()
	void AP() {
		// Mark all the vertices as not visited
		final boolean visited[] = new boolean[this.graph.V];
		final int disc[] = new int[this.graph.V];
		final int low[] = new int[this.graph.V];
		final int parent[] = new int[this.graph.V];
		final boolean ap[] = new boolean[this.graph.V]; // To store articulation points

		// Initialize parent and visited, and ap(articulation point)
		// arrays
		for (int i = 0; i < this.graph.V; i++) {
			parent[i] = ArticulationPoint.NIL;
			visited[i] = false;
			ap[i] = false;
		}

		// Call the recursive helper function to find articulation
		// points in DFS tree rooted with vertex 'i'
		for (int i = 0; i < this.graph.V; i++) {
			if (visited[i] == false) {
				this.APUtil(i, visited, disc, low, parent, ap);
			}
		}

		// Now ap[] contains articulation points, print them
		for (int i = 0; i < this.graph.V; i++) {
			if (ap[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	// Driver method
	public static void main(final String args[]) {
		// Create graphs given in above diagrams
		System.out.println("Articulation points in first graph ");
		final Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		ArticulationPoint ap = new ArticulationPoint(g1);
		ap.AP();
		System.out.println();

		System.out.println("Articulation points in Second graph");
		final Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		ap = new ArticulationPoint(g2);
		ap.AP();
		System.out.println();

		System.out.println("Articulation points in Third graph ");
		final Graph g3 = new Graph(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		ap = new ArticulationPoint(g3);
		ap.AP();
	}
}
// This code is contributed by Aakash Hasija
