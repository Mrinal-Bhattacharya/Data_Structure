package com.interviewbit.graph.connectivity;

import com.java.graph.Graph;

public class CyclicWithColor {
    static int WHITE = 0, GRAY = 1, BLACK = 2;

    public static void main(final String[] args) {
        final Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        if (isCyclicColor(graph)) {
            System.out.println("cyclic");
        }
        else {
            System.out.println("Non cyclic");
        }
    }

    static boolean isCyclicColor(final Graph g) {
        // Initialize color of all vertices as WHITE
        final int[] color = new int[g.V];
        for (int i = 0; i < g.V; i++) {
            color[i] = CyclicWithColor.WHITE;
        }

        // Do a DFS traversal beginning with all
        // vertices
        for (int i = 0; i < g.V; i++) {
            if (color[i] == CyclicWithColor.WHITE) {
                if (CyclicWithColor.isCyclicColorUtil(g, i, color) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicColorUtil(final Graph g, final int u, final int[] color) {
        // GRAY : This vertex is being processed (DFS for this vertex has started, but not
        // ended (or this vertex is in function call stack)
        color[u] = CyclicWithColor.GRAY;

        // Iterate through all adjacent vertices
        for (final Integer in : g.adj[u]) {
            // If there is
            if (color[in] == CyclicWithColor.GRAY) {
                return true;
            }

            // If v is not processed and there is a back
            // edge in subtree rooted with v
            if ((color[in] == CyclicWithColor.WHITE) && (isCyclicColorUtil(g, in, color) == true)) {
                return true;
            }
        }

        // Mark this vertex as processed
        color[u] = CyclicWithColor.BLACK;
        return false;
    }
}
