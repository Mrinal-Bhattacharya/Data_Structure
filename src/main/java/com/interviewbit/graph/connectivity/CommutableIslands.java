package com.interviewbit.graph.connectivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
                return x.get(x.size() - 1) - y.get(y.size() - 1);
            }
        });
        int ans = 0;
        Graph graph = new Graph(A);
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> b = B.get(i);
            if (graph.find(b.get(0)) != graph.find(b.get(1))) {
                ans += b.get(2);
                graph.union(b.get(0), b.get(1));
            }
        }
        return ans;
    }

    class Graph {
        Subset[] subset;

        Graph(int v) {
            this.subset = new Subset[v + 1];
            for (int i = 0; i <= v; i++) {
                subset[i] = new Subset();
                subset[i].parent = i;
                subset[i].rank = 0;
            }
        }

        public void union(int x1, int y1) {
            int x = find(x1);
            int y = find(y1);

            if (subset[x].rank < subset[y].rank) subset[x].parent = y;
            else if (subset[y].rank < subset[x].rank) subset[y].parent = x;
            else {
                subset[x].parent = y;
                subset[y].rank++;
            }
        }

        public int find(int node) {
            if (this.subset[node].parent != node) this.subset[node].parent = find(this.subset[node].parent);
            return this.subset[node].parent;
        }

        class Subset {
            int parent;
            int rank;
        }

    }
}
