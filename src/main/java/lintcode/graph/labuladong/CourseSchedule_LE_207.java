package lintcode.graph.labuladong;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_LE_207 {
    /**
     1.29.2023
     ref 东哥图遍历框架, 使用邻接表
     */
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int node) {
        if (onPath[node]) {
            hasCycle = true;
            return;
        }
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        onPath[node] = true;
        for (int n : graph[node]) {
            traverse(graph, n);
        }
        onPath[node] = false;
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
