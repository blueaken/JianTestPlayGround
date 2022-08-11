package lintcode.graph;

import java.util.*;

public class CourseSchedule_LE_207_With_IntArray {
    /*
        - redo after reading 花花's 207. Course Schedule video
        - ref https://www.youtube.com/watch?v=M6SBePBMznU
        - use int array replace hashmap to record state, more efficient than previous submission, 8ms vs 34ms
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[1], v = edge[0];
            graph.get(u).add(v);
        }

        //0 - original, 1 - visiting, 2 - visited
        int[] state = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, state, graph, stack)) {
                //a cycle detected
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        int pos = 0;
        while (!stack.isEmpty()) {
            ans[pos++] = stack.removeLast();
        }
        return ans;
    }

    //return true if cycle detected, otherwise return true
    private boolean dfs(int node, int[] state, Map<Integer, List<Integer>> graph, Deque<Integer> stack) {
        if (state[node] == 1) {
            //cycle found
            return true;
        }
        if (state[node] == 2) {
            return false;
        }

        state[node] = 1;
        for (Integer neigh : graph.get(node)) {
            if (dfs(neigh, state, graph, stack)) {
                return true;
            }
        }
        state[node] = 2;
        stack.addLast(node);
        return false;
    }
}
