package com.interviewbit.graph.connectivity;

import com.java.graph.Graph;

import java.util.Iterator;

public class CyclicWithParent {
    public static void cyclicWithParent() {
        // Create a graph given in the above diagram
        final Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (isCyclic(g1)) {
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contains cycle");
        }
        final Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (isCyclic(g2)) {
            System.out.println("Graph contains cycle");
        }
        else {
            System.out.println("Graph doesn't contains cycle");
        }
    }

    // Returns true if the graph contains a cycle, else false.
    static Boolean isCyclic(final Graph graph) {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        final Boolean[] visited = new Boolean[5];
        for (int i = 0; i < graph.V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < graph.V; u++) {
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1, graph)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCyclicUtil(final int v, final Boolean[] visited, final int parent, final Graph graph) {
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        final Iterator<Integer> it = graph.adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v, graph)) {
                    return true;
                }
            }
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    static void isTree(final Graph g) {
        // 1) There is no cycle.
        // 2) The graph is connected.
        final Boolean[] visited = new Boolean[5];
        for (int i = 0; i < g.V; i++) {
            visited[i] = false;
        }
        if (isCyclicUtil(0, visited, -1, g)) {
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
        isTree(g1);
        g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        isTree(g1);
    }
}
