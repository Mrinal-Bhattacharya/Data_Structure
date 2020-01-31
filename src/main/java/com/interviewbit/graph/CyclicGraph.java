package com.interviewbit.graph;

public class CyclicGraph {
    int V, E; // V-> no. of vertices & E->no.of edges
    Edge[] edge; // /collection of all edges

    // Creates a graph with V vertices and E edges
    public CyclicGraph(final int v, final int e) {
        this.V = v;
        this.E = e;
        this.edge = new Edge[this.E];
        for (int i = 0; i < e; ++i) {
            this.edge[i] = new Edge();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Edge[] getEdge() {
        return edge;
    }

    static public class Edge {
        int src, dest;

        public int getSrc() {
            return src;
        }

        public void setSrc(final int src) {
            this.src = src;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(final int dest) {
            this.dest = dest;
        }
    }
}
