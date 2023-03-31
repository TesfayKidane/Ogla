package blind75.graph.ds;

import java.util.Set;

public interface Graph {
    boolean addVertex(Integer v);
    boolean addEdge(Integer v1, Integer v2);
    Set<Integer> getVertices();
    Set<Integer> getNeighbours(Integer v);
    Integer size();
}
