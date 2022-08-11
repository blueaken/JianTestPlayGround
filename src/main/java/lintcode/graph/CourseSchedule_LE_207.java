package lintcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule_LE_207 {
    /*
        - ref https://www.youtube.com/watch?v=M6SBePBMznU
        - topological sort to find if cycle exists
        - each node has 3 state: original, visiting & visited
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        //build map
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[1], v = edge[0];
            graph.get(u).add(v);
        }

        int[] state = new int[numCourses]; //0-original, 1-visiting, 2-visited
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, state, graph)) {
                return false;
            }
        }
        return true;
    }

    //return true if cycle detected, otherwise return false;
    private boolean dfs(int node, int[] state, Map<Integer, List<Integer>> graph) {
        //cycle detected
        if (state[node] == 1) {
            return true;
        }
        //node is visited
        if (state[node] == 2) {
            return false;
        }

        //update cur node state to visiting
        state[node] = 1;
        for (Integer neighbor : graph.get(node)) {
            if (dfs(neighbor, state, graph)) {
                return true;
            }
        }
        state[node] = 2;
        //if needed, add order access list here
        return false;
    }
}
