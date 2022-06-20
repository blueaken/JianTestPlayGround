package lintcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule2_LE_210_DFS_P1 {
    /*
        typical graph topological sort
        1. - try bfs first, since looks easier to build indegree map from provided input
        2. - try dfs, update with a state map and boolean flag to catch cycle, visited set not needed any more, ref - https://leetcode.com/problems/course-schedule-ii/solution/
        Time - O(V + E), Space - O(V + E)
    */
    Map<Integer, Integer> state = new HashMap<>(); //courseId, state: 0 - unprocessed, 1 - processing, 2 - processed
    boolean isCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //init state map
        for (int i = 0; i < numCourses; i++) {
            state.put(i, 0);
        }

        //start dfs
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (state.get(i) == 0) {
                dfs(i, stack, prerequisites);
            }
        }

        if (isCycle) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private void dfs(Integer node, Stack stack, int[][] prerequisites) {
        if (this.isCycle) {
            return;
        }

        //update node state to processing
        state.put(node, 1);
        for (int[] cur : prerequisites) {
            if (cur[1] == node) {
                Integer s = state.get(cur[0]);
                if (s == 0) {
                    //if unprocessed, keep dfs
                    dfs(cur[0], stack, prerequisites);
                } else if (s == 1) {
                    //if processing, a cycle detected
                    this.isCycle = true;
                    return;
                }
            }
        }
        //when dfs finishes update state to processed
        state.put(node, 2);
        stack.push(node);
    }

    public static void main(String[] args) {
        CourseSchedule2_LE_210_DFS_P1 solution = new CourseSchedule2_LE_210_DFS_P1();
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
