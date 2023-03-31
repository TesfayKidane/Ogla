package blind75.graph;
import java.util.*;
/*
n = 3, edges = [[0,1], [1,2], [2,0]], s = 0, d = 2
    (0)
   /   \
 (2)---(1)

 */

public class FindIfPathExistsInGraph {
    boolean pathFound = false;
    public boolean validPath(int n, int[][] edges, int s, int d) {

        if(n == 1 && edges.length == 0 && s == 0 && d == 0)
            return true;

        // first construct graph
        Graph udGraph = new UnDirectedGraph();
        Set<Integer> visited = new HashSet<>();

        // add all vertexies
        for(int i = 0 ; i < n; i++) {
            udGraph.addVertex(i);
        }

        // add edges for each vertex
        for(int j = 0; j < edges.length; j++) {
            udGraph.addEdge(edges[j][0], edges[j][1]);
        }
        dfs(udGraph, visited, s, d);
        return pathFound;
    }

    private void dfs(Graph udGraph, Set<Integer> visited, int start, int destination) {
        if(visited.contains(start) || pathFound) return;

        visited.add(start);

        for(Integer neighbour : udGraph.getNeighbours(start)) {
            if (neighbour == destination) {
                pathFound = true;
                break;
            }
            if(!visited.contains(neighbour))
                dfs(udGraph, visited, neighbour, destination);
        }
    }

    class UnDirectedGraph implements Graph {
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();

        @Override
        public boolean addVertex(Integer v) {
            graphMap.put(v, new HashSet<>());
            return true;
        }

        @Override
        public boolean addEdge(Integer v1, Integer v2) {
            if (!graphMap.containsKey(v1) || !graphMap.containsKey(v2))
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
    interface Graph {
        boolean addVertex(Integer v);
        boolean addEdge(Integer v1, Integer v2);
        Set<Integer> getVertices();
        Set<Integer> getNeighbours(Integer v);
        Integer size();
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] { {0,1}, {1,2}, {2,0}};
        FindIfPathExistsInGraph f = new FindIfPathExistsInGraph();
        System.out.println(f.validPath(3, edges, 1,2));
    }
}
