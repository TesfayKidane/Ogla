package blind75.graph;

import java.util.*;

public class NumberOfConnectedComponents {
    // Brue force (dfs) - starting from each node, see if you can produce isolated component.
    public int countComponents(int n, int[][] edges) {
        // create adjusency list
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] e : edges) {
            if(adjMap.containsKey(e[0]) && !adjMap.get(e[0]).contains(e[1])) {
                adjMap.get(e[0]).add(e[1]);
            }
        }

        int count = 0;
        // created visited nodes.
        Set<Integer> visited = new HashSet<>();
        // starting from each node, search for connected components.
        for(int i = 0 ; i < n; i++) {
            if(dfs(adjMap, visited, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(Map<Integer, List<Integer>> adjMap, Set<Integer> visited, int node) {
        // base case
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for(Integer nei : adjMap.get(node)) {
            if(!dfs(adjMap, visited, nei)) {
                return false;
            }
        }
        return true;
    }
}
