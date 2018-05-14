package com.java.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	public final int V;
	public final List<Integer> adj[];
	int intime[];
	int outtime[];
	int timer = 0;

	public Graph(final int v) {
		this.V = v;
		this.adj = new List[v];
		this.intime = new int[v];
		this.outtime = new int[v];
		for (int i = 0; i < this.V; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	void addEdge(final int s, final int t) {
		this.adj[s].add(t);
	}

	void BFS(final int sourceVertex) {
		final boolean[] visited = new boolean[this.V];
		final LinkedList<Integer> queue = new LinkedList<>();
		visited[sourceVertex] = true;
		queue.add(sourceVertex);
		while (!queue.isEmpty()) {
			final Integer vertex = queue.poll();
			System.out.println(vertex);
			final ListIterator<Integer> neighbours = this.adj[vertex].listIterator();
			while (neighbours.hasNext()) {
				final Integer nextVertex = neighbours.next();
				if (!visited[nextVertex]) {
					visited[nextVertex] = true;
					queue.add(nextVertex);
				}
			}
		}
	}

	void DFS() {
		final boolean[] visited = new boolean[this.V];
		for (int i = 0; i < this.V; i++) {
			if (!visited[i]) {
				this.DFSUtil(i, visited);
			}
		}
	}

	void DFS(final int sourceVertex) {
		final boolean[] visited = new boolean[this.V];
		this.DFSUtil(sourceVertex, visited);
	}

	int findMother() {
		boolean[] visited = new boolean[this.V];
		int v = -1;
		for (int i = 0; i < this.V; i++) {
			if (!visited[i]) {
				this.DFSUtil(i, visited);
				v = i;
			}
		}
		visited = new boolean[this.V];
		this.DFSUtil(v, visited);
		for (int i = 0; i < this.V; i++) {
			if (visited[i] == false) {
				return -1;
			}
		}
		return v;
	}

	void DFSUtil(final int sourceVertex, final boolean[] visited) {
		visited[sourceVertex] = true;
		System.out.print(sourceVertex + " ");
		final ListIterator<Integer> neighbours = this.adj[sourceVertex].listIterator();
		while (neighbours.hasNext()) {
			final Integer nextVertex = neighbours.next();
			if (!visited[nextVertex]) {
				this.DFSUtil(nextVertex, visited);
			}

		}

	}

	void DFSWithTime(final int sourceVertex) {
		final boolean[] visited = new boolean[this.V];
		this.DFSWithTimeUtil(sourceVertex, visited);
	}

	private void DFSWithTimeUtil(final int sourceVertex, final boolean[] visited) {
		visited[sourceVertex] = true;
		++this.timer;
		System.out.print(sourceVertex + " ");
		this.intime[sourceVertex] = this.timer;
		final ListIterator<Integer> neighbours = this.adj[sourceVertex].listIterator();
		while (neighbours.hasNext()) {
			final Integer nextVertex = neighbours.next();
			if (!visited[nextVertex]) {
				this.DFSWithTimeUtil(nextVertex, visited);
			}

		}
		++this.timer;
		this.outtime[sourceVertex] = this.timer;

	}

	boolean query(final int u, final int v) {
		return (((this.intime[u] < this.intime[v]) && (this.outtime[u] > this.outtime[v]))
				|| ((this.intime[v] < this.intime[u]) && (this.outtime[v] > this.outtime[u])));
	}

	void topologicalSort() {
		final Stack<Integer> stack = new Stack<>();
		final boolean[] visited = new boolean[this.V];
		for (int i = 0; i < this.V; i++) {
			if (!visited[i]) {
				this.topologicalSortUtil(i, visited, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	private void topologicalSortUtil(final int sourceVertex, final boolean[] visited, final Stack<Integer> stack) {
		visited[sourceVertex] = true;
		final ListIterator<Integer> neighbours = this.adj[sourceVertex].listIterator();
		while (neighbours.hasNext()) {
			final Integer vertex = neighbours.next();
			if (!visited[vertex]) {
				this.topologicalSortUtil(vertex, visited, stack);
			}

		}
		stack.push(sourceVertex);
	}

	public void jumpingBFS(final int x, int num) {
		// Create a queue and enqueue 'i' to it
		final Queue<Integer> q = new LinkedList<>();
		q.add(num);

		// Do BFS starting from i
		while (!q.isEmpty()) {
			num = q.peek();
			q.poll();
			if (num <= x) {
				System.out.print(num + " ");
				final int last_digit = num % 10;

				// If last digit is 0, append next digit only
				if (last_digit == 0) {
					q.add((num * 10) + (last_digit + 1));
				}

				// If last digit is 9, append previous digit only
				else if (last_digit == 9) {
					q.add((num * 10) + (last_digit - 1));
				}

				// If last digit is neighter 0 nor 9, append both
				// previous and next digits
				else {
					q.add((num * 10) + (last_digit - 1));
					q.add((num * 10) + (last_digit + 1));
				}
			}
		}
	}

	public void DFSItr() {
		final boolean[] visited = new boolean[this.V];
		for (int i = 0; i < this.V; i++) {
			if (!visited[i]) {
				this.DFSItrUtil(i, visited);
			}
		}
	}

	private void DFSItrUtil(final int i, final boolean[] visited) {
		final Stack<Integer> stack = new Stack<>();
		stack.push(i);
		while (!stack.isEmpty()) {
			final Integer item = stack.pop();
			if (!visited[item]) {
				visited[item] = true;
				System.out.println(item);
				final List<Integer> list = this.adj[item];
				for (final Integer other : list) {
					if (!visited[other]) {
						stack.push(other);
					}
				}
			}
		}

	}

	public void printJumping(final int x) {
		System.out.print("0 ");
		for (int i = 1; (i <= 9) && (i <= x); i++) {
			this.jumpingBFS(x, i);
		}
	}

	// Driver method to
	public static void main(final String args[]) {
		final Graph g = new Graph(5);
		g.printJumping(40);
		Graph.motherVertics();
		Graph.path();
		Graph.bothTypeOfTraversal();
		Graph.displaytopologicalSort();
		Graph.dfsItr();
	}

	private static void dfsItr() {
		final Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println();
		System.out.println("DFS Iterative");
		g.DFSItr();
	}

	private static void motherVertics() {
		final Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);
		System.out.println("find mother " + g.findMother());
	}

	private static void path() {
		final Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 5);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(4, 8);
		g.DFSWithTime(0);
		if (g.query(0, 4)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}
		if (g.query(1, 8)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}
		if (g.query(1, 5)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}
	}

	private static void displaytopologicalSort() {
		// Create a graph given in the above diagram
		final Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();
	}

	private static void bothTypeOfTraversal() {
		final Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.BFS(2);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.DFS();
		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
	}
}
