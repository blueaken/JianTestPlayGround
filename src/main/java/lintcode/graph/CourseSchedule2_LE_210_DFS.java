package lintcode.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule2_LE_210_DFS {
    /*
        typical graph topological sort
        1. - try bfs first, since looks easier to build indegree map from provided input
        2. - try dfs, update with a state map and boolean flag to catch cycle, visited set not needed any more, ref - https://leetcode.com/problems/course-schedule-ii/solution/
    */

    int unProcessed = 1;
    int processing = 2;
    int processed = 3;
    Map<Integer, Integer> stateMap = new HashMap<>(); //courseId, state
    boolean isCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //init nodes state
        for (int i = 0; i < numCourses; i++) {
            stateMap.put(i, unProcessed);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (this.stateMap.get(i) == unProcessed) {
                dfs(i, stack, prerequisites);
            }
        }

        //if there is a cycle, cannot finish the topological sort, return empty array
        if (this.isCycle) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private void dfs(Integer node, Stack<Integer> stack, int[][] prerequisites) {
        // Don't recurse further if we found a cycle already
        if (this.isCycle) {
            return;
        }

        // Start the recursion
        this.stateMap.put(node, processing);

        for (int[] cur : prerequisites) {
            if (cur[1] == node) {
                if (this.stateMap.get(cur[0]) == unProcessed) {
                    dfs(cur[0], stack, prerequisites);
                } else if (this.stateMap.get(cur[0]) == processing) {
                    // An edge to a processing vertex represents a cycle, update the flag and return
                    this.isCycle = true;
                    return;
                }
            }
        }
        // Recursion ends, update the state
        this.stateMap.put(node, processed);
        stack.push(node);
    }
}
