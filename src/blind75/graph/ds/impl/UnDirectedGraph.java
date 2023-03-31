package blind75.graph.ds.impl;

import blind75.graph.ds.Graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnDirectedGraph implements Graph {
    Map<Integer, Set<Integer>> graphMap = new HashMap<>();

    @Override
    public boolean addVertex(Integer v) {
        graphMap.put(v, new HashSet<>());
        return true;
    }

    @Override
    public boolean addEdge(Integer v1, Integer v2) {
        if(!graphMap.containsKey(v1) || !graphMap.containsKey(v2))
            return false;
        graphMap.get(v1).add(v2);
        graphMap.get(v2).add(v1);
        return true;
    }

    @Override
    public Set<Integer> getVertices() {
        return new HashSet<>(graphMap.keySet());
    }

    @Override
    public Set<Integer> getNeighbours(Integer v) {
        return graphMap.get(v);
    }

    @Override
    public Integer size() {
        return graphMap.size();
    }
}
