package lintcode.graph.labuladong;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_LE_785_BFS {
    /**
     1.30.2023
     ref 东哥 图DFS框架
     ==================
     try 东哥 图BFS框架
     */

    // 也可以用一个 int[] visited数组代替这2个数组，但代码写起来稍微复杂点
    boolean[] visited;
    boolean[] color;
    boolean isOk = true; // default to true
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        // since the graph may not be connected, we need to iterate each node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }
        return isOk;
    }

    private void bfs(int[][] graph, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (queue.size() > 0 && isOk) {
            int cur = queue.poll();
            for (int neigh : graph[cur]) {
                if (!visited[neigh]) {
                    // if neighbor not visited, then set its color diff from the current node
                    color[neigh] = !color[cur];
                    // continue bfs
                    visited[neigh] = true;
                    queue.offer(neigh);
                } else {
                    if (color[neigh] == color[cur]) {
                        isOk = false;
                        return;
                    }
                }
            }
        }

    }
}
