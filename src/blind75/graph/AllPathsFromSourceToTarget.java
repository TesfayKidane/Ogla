/*
graph graph;

import blind75.graph.ds.Graph;
import blind75.graph.ds.impl.DirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsFromSourceToTarget {

    boolean found = false;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Graph dg = new DirectedGraph();

        // add all vertex
        for (int i = 0; i < graph.length; i++) {
            dg.addVertex(i);
        }

        // add edges
        for (int j = 0; j < graph.length; j++) {
            int[] neighbours = graph[j];
            for (int k = 0; k < neighbours.length; k++) {
                dg.addEdge(j, neighbours[k]);
            }
            System.out.println(j + " - " +dg.getNeighbours(j));
        }
        List<List<Integer>> allPaths = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(allPaths, visited, path, dg, 0, graph.length - 1);
        return null;
    }

    private List<List<Integer>> dfs(List<List<Integer>> allPaths, Set<Integer> visited, List<Integer> path, Graph dg, int s, int d) {
        if(visited.contains(d) || found) return allPaths;

        for(Integer n : dg.getNeighbours(s)) {
            if (n == d) {
                path.add(n);
                allPaths.add(path);
                break;
            }

            if(!visited.contains(n)) {
                dfs(allPaths, visited, path, dg, n, d);
            }
        }

    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        int[][] company.google = new int[][] {{4,3,1}, {3,2,4}, {3},{4}, {}};
        a.allPathsSourceTarget(company.google);
    }
}
*/
