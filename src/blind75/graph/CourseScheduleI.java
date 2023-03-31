package blind75.graph;

import java.util.*;

public class CourseScheduleI {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0) return false;
        if((prerequisites.length == 0 || prerequisites[0].length == 0 ) && numCourses > 0) return true;
        // create adju map
        Map<Integer, List<Integer>> courseAndPreReq = new HashMap<>();
        for(int i = 0 ; i < numCourses; i++) {
            courseAndPreReq.put(i, new ArrayList<>());
        }

        boolean[] cycle = new boolean[numCourses];
        Arrays.fill(cycle, false);

        // copy prerequisites to the  map
        for(int[] p : prerequisites) {
            int keyCourse = p[0];
            int preCourse = p[1];
            List<Integer> list = courseAndPreReq.getOrDefault(keyCourse, new ArrayList<>());
            if (keyCourse >= numCourses || keyCourse < 0 || preCourse >= numCourses || preCourse < 0)
                return false;
            list.add(preCourse);
            courseAndPreReq.put(keyCourse, list);
        }

        // for each course i, in the map, check if it can finished (i.e no cycle).
        for(int currentCourseI = 0; currentCourseI < numCourses; currentCourseI++) {
            if (!dfs(courseAndPreReq, currentCourseI, cycle))
                return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> courseAndPreReq, int currentCourseI, boolean[] cycle) {
         if(cycle[currentCourseI]) { // cycle detected
             return false;
         }
         if(courseAndPreReq.containsKey(currentCourseI) &&
         courseAndPreReq.get(currentCourseI).isEmpty()) { // all pre requesite have been checked.
             return true;
         }

         cycle[currentCourseI] = true;
         for(Integer preI : courseAndPreReq.get(currentCourseI)) {
            if(!dfs(courseAndPreReq, preI, cycle))
                return false;
         }
         cycle[currentCourseI] = false;
         courseAndPreReq.put(currentCourseI, new ArrayList<>());
         return true;
    }

    public static void main(String[] args) {
        CourseScheduleI csI = new CourseScheduleI();
        int[][] pre = {{1,0}};
        System.out.println(csI.canFinish(2,pre));
    }
}
