package lintcode.graph.labuladong;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2_LE_210_BFS {
    /**
     1.29.2023
     ref 东哥图遍历框架, 使用邻接表
     ===========================
     1.30.2023
     try BFS框架
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // build indegree array
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        // select indgree 0 node(s) as start node
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        int count = 0; // count traverse node number
        while (queue.size() > 0) {
            Integer cur = queue.poll();
            count++;
            res[idx++] = cur;

            for (int neigh : graph[cur]) {
                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        if (count < numCourses) {
            return new int[] {};
        }

        return res;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
