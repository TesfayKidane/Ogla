package blind75.graph;

import java.util.*;

public class CourseScheduleII {

    /**
     * Topological Sort: is a way of sorting starting from a node (verticies) with on dependencies / pre-requeisites.
     * Time : O(E + V) where E is number of edges and V is the number verticies.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1 && prerequisites.length == 0) {
            int[] r = new int[1];
            r[0] = 0;
            return r;
        }

        if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return new int[0];
        }
        // create adjucency list
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int n = 0 ; n < numCourses; n++) {
            adjMap.put(n, new HashSet<>());
        }

        for(int[] pre : prerequisites) {
            if(pre[0] < 0 || pre[0] >= numCourses || pre[1] < 0 || pre[1] >= numCourses) {
                return new int[0];
            }
            Set<Integer> adj = adjMap.get(pre[0]);
            adj.add(pre[1]);
            adjMap.put(pre[0], adj);
        }

        // create visited and cycle hashsets and result array list
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int node = 0 ; node < numCourses; node++) {
            if(!dfs(node, adjMap, visited, cycle, result)) {
                return new int[0];
            }
        }

        int[] resultInt = new int[numCourses];
        for(int i = 0 ; i < result.size(); i++) {
            resultInt[i] = result.get(i);
        }
        return resultInt;
    }

    private boolean dfs(int node, Map<Integer, Set<Integer>> adjMap, Set<Integer> visited, Set<Integer> cycle, List<Integer> result) {
       // base case
        // cycle hash set contains the node that we are currently visiting,
        // and if the node is already in the set then we should return false.
        if(cycle.contains(node)) {
            return false;
        }

        if(visited.contains(node)) {
            return true;
        }

        cycle.add(node);

        for(Integer nei : adjMap.get(node)) {
            if(!dfs(nei, adjMap, visited, cycle, result)) {
                return false;
            }
        }

        visited.add(node);
        cycle.remove(node);
        result.add(node);
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII csII = new CourseScheduleII();
        int[][] pre1 = {{1,0}};
        int[] result1 = csII.findOrder(2, pre1);
        System.out.println(Arrays.toString(result1));

        int[][] pre2 = {{1,0},{2,0},{3,1},{3,2}};
        int[] result2 = csII.findOrder(4, pre2);
        System.out.println(Arrays.toString(result2));

        int[][] pre3 = new int[0][0];
        int[] result3 = csII.findOrder(1, pre3);
        System.out.println(Arrays.toString(result3));
    }
}
