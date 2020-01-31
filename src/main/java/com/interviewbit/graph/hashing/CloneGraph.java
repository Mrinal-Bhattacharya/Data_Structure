package com.interviewbit.graph.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> labelsVisited = new HashMap<Integer, UndirectedGraphNode>();
        return auxCloneGraph(node, labelsVisited);
    }

    private UndirectedGraphNode auxCloneGraph(final UndirectedGraphNode node, final Map<Integer, UndirectedGraphNode> labelsVisited) {
        if (labelsVisited.containsKey(node.label)) {
            return labelsVisited.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        labelsVisited.put(node.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(auxCloneGraph(neighbor, labelsVisited));
        }
        return clone;
    }
}

//  Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
