package com.interviewbit.graph.connectivity;


import com.interviewbit.graph.CyclicGraph;

public class CycleUnionAndFind {
    public static void unionAndFind() {
        final int V = 3, E = 3;
        final CyclicGraph graph = new CyclicGraph(V, E);

        // add edge 0-1

        graph.getEdge()[0].setSrc(0);
        graph.getEdge()[0].setDest(1);

        // add edge 1-2
        graph.getEdge()[1].setSrc(1);
        graph.getEdge()[1].setDest(2);

        // add edge 0-2
        graph.getEdge()[2].setSrc(0);
        graph.getEdge()[2].setDest(2);

        if (isCycle(graph) == 1) {
            System.out.println("graph contains cycle");
        }
        else {
            System.out.println("graph doesn't contain cycle");
        }
    }

    private static int isCycle(final CyclicGraph graph) {
        final int[] parent = new int[graph.getV()];
        for (int i = 0; i < graph.getV(); ++i) {
            parent[i] = -1;
        }
        for (int i = 0; i < graph.getE(); ++i) {
            final int x = find(parent, graph.getEdge()[i].getSrc());
            final int y = find(parent, graph.getEdge()[i].getDest());
            if (x == y) {
                return 1;
            }

            union(parent, x, y);
        }
        return 0;
    }

    private static void union(final int[] parent, final int x, final int y) {
        final int xset = find(parent, x);
        final int yset = find(parent, y);
        parent[xset] = yset;
    }

    private static int find(final int[] parent, final int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
}
