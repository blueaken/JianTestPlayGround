package lintcode.graph.labuladong;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2_LE_210 {
    /**
     1.29.2023
     ref 东哥图遍历框架, 使用邻接表
     */

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        stack = new Stack<>();

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new int[] {};
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int node) {
        if (onPath[node]) {
            hasCycle = true;
            return;
        }
        if (visited[node]) {
            return;
        }

        onPath[node] = true;
        visited[node] = true;
        for (int n : graph[node]) {
            traverse(graph, n);
        }
        // 后序位置
        stack.push(node);
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
