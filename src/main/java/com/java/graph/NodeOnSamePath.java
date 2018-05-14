package com.java.graph;

import java.util.ListIterator;

public class NodeOnSamePath {
	public boolean[] visited;
	public int[] inTime;
	public int[] outTime;
	public int timer = 0;

	public NodeOnSamePath(final int v) {
		this.visited = new boolean[v];
		this.inTime = new int[v];
		this.outTime = new int[v];
	}

	void dfs(final Graph graph, final int s) {
		this.visited[s] = true;
		++this.timer;
		this.inTime[s] = this.timer;
		final ListIterator<Integer> nodes = graph.adj[s].listIterator();
		while (nodes.hasNext()) {
			final Integer node = nodes.next();
			if (!this.visited[node]) {
				this.dfs(graph, node);
			}
		}
		++this.timer;
		this.outTime[s] = this.timer;
	}

	boolean query(final int u, final int v) {
		return (((this.inTime[u] < this.inTime[v]) && (this.outTime[u] > this.outTime[v]))
				|| ((this.inTime[v] < this.inTime[u]) && (this.outTime[v] > this.outTime[u])));
	}

	public static void main(final String[] args) {
		final Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		final NodeOnSamePath nodeOnSamePath = new NodeOnSamePath(7);
		nodeOnSamePath.dfs(g, 0);
		System.out.println(nodeOnSamePath.query(0, 4));
		System.out.println(nodeOnSamePath.query(0, 5));
		System.out.println(nodeOnSamePath.query(1, 5));
	}
}
