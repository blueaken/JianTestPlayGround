package lintcode.graph;

import java.util.*;

public class CourseSchedule2_LE_210 {
    /*
        typical graph topological sort
        - try bfs first, since looks easier to build indegree map from provided input
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<>(); //courseId, indegree
        //build indegree map
        for (int[] cur : prerequisites) {
            if (indegree.containsKey(cur[0])) {
                indegree.put(cur[0], indegree.get(cur[0]) + 1);
            } else {
                indegree.put(cur[0], 1);
            }
        }

        //put start node(s) in queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i)) {
                queue.offer(i);
            }
        }

        //bfs from start node(s)
        List<Integer> res = new ArrayList<>();
        int pos = 0;
        while (queue.size() > 0) {
            int courseId = queue.poll();
            res.add(courseId);
            for (int[] cur : prerequisites) {
                if (cur[1] == courseId) {
                    indegree.put(cur[0], indegree.get(cur[0]) - 1);
                    if (indegree.get(cur[0]) == 0) {
                        queue.offer(cur[0]);
                    }
                }
            }
        }
        //if there is a cycle, cannot finish the topological sort, return empty array
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        CourseSchedule2_LE_210 solution = new CourseSchedule2_LE_210();
//        int numCourses = 2;
//        int[][] prerequisites = {{1,0}};
//        //[0,1]

//        int numCourses = 4;
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        //[0,2,1,3]

//        int numCourses = 2;
//        int[][] prerequisites = {{1,0},{0,1}};
//        //[]

        int numCourses = 3;
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        //[]

        System.out.println(Arrays.toString(solution.findOrder(numCourses, prerequisites)));
    }
}
