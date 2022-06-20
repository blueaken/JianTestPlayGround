package lintcode.graph;

import java.util.*;

public class CourseSchedule2_LE_210_BFS_P1 {
    /*
        typical graph topological sort
        - try bfs first, since looks easier to build indegree map from provided input
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegree = new HashMap<>();
        //build indegree map
        for (int[] cur : prerequisites) {
            indegree.put(cur[0], indegree.getOrDefault(cur[0], 0) + 1);
        }

        //load start node(s) into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i)) {
                queue.offer(i);
            }
        }

        //start bfs
        List<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            Integer curNode = queue.poll();
            res.add(curNode);
            for (int[] cur : prerequisites) {
                if (cur[1] == curNode) {
                    int indegreeVal = indegree.get(cur[0]);
                    indegreeVal--;
                    indegree.put(cur[0], indegreeVal);
                    if (indegreeVal == 0) {
                        queue.offer(cur[0]);
                    }
                }
            }
        }
        //if there is cycle, res size will not be full, return empty array
        if (res.size() < numCourses) {
            return new int[0];
        }

        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        CourseSchedule2_LE_210_BFS_P1 solution = new CourseSchedule2_LE_210_BFS_P1();
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
