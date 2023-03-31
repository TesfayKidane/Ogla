package blind75.graph.ds.impl;

import blind75.graph.ds.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph implements Graph {
    Map<Integer, HashSet<Integer>> dGraph = new HashMap<>();

    @Override
    public boolean addVertex(Integer v) {
        dGraph.put(v, new HashSet<>());
        return true;
    }

    @Override
    public boolean addEdge(Integer v1, Integer v2) {
        if(!dGraph.containsKey(v1) || !dGraph.containsKey(v2)) return false;
        dGraph.get(v1).add(v2);
        return true;
    }

    @Override
    public Set<Integer> getVertices() {
        return new HashSet<>(dGraph.keySet());
    }

    @Override
    public Set<Integer> getNeighbours(Integer v) {
        return dGraph.get(v);
    }

    @Override
    public Integer size() {
        return dGraph.size();
    }
}
