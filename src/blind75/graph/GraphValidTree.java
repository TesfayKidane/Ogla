package blind75.graph;

import java.util.*;

/**
 * 261. Graph Valid Tree
 *
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || n == 1) return true;

        if (edges == null || edges.length == 0 || edges[0].length == 0) return false;

        // create adjacency map
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjacencyMap.putIfAbsent(node1, new ArrayList<>());
            adjacencyMap.putIfAbsent(node2, new ArrayList<>());

            adjacencyMap.get(node1).add(node2);
            adjacencyMap.get(node2).add(node1);
        }

        // if the adjacencyMap doesn't contain all the nodes, then return false;
        if(adjacencyMap.size() < n) return false;

        Set<Integer> visited = new HashSet<>();

        boolean noCycleDetected = dfs(adjacencyMap, 0, -1, visited);


        // if all nodes are visited then size of Visited set should be equal to n
        boolean allNodesVisited = n == visited.size();

        return noCycleDetected && allNodesVisited;
    }

    private boolean dfs(Map<Integer, List<Integer>> adjacencyMap, int node, int prevNode, Set<Integer> visited) {

        // if node is visited, then cycle is detected so tree is invalid
        if (visited.contains(node)) return false;

        // add current node to visited set
        visited.add(node);

        // check the current nodes adjacent nodes
        for (Integer adjacentNode : adjacencyMap.get(node)) {
            // skip evaluating the previous node
            if(adjacentNode == prevNode) continue;

            // if there is cycle detected for any of the adjacent nodes then tree is invalid.
            if(!dfs(adjacencyMap, adjacentNode, node, visited)) return false;
        }

        // if no cycle is detected in the node and it's adjacent nodes then return true.
        return true;
    }
}
