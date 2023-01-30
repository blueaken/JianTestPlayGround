package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition_LE_886 {
    /**
     1.30.2023
     ref 东哥图遍历框架，similar to LE 785
     */
    boolean[] visited;
    boolean[] color;
    boolean isOk = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // node start from 1
        visited = new boolean[n+1];
        color = new boolean[n+1];

        // build邻接表
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return isOk;
    }

    private void traverse(List<Integer>[] graph, int node) {
        if (!isOk) {
            return;
        }

        visited[node] = true;
        List<Integer> neighs = graph[node];
        for (int neigh : neighs) {
            if (!visited[neigh]) {
                visited[neigh] = true;
                color[neigh] = !color[node];

                // continue dfs
                traverse(graph, neigh);
            } else {
                if (color[neigh] == color[node]) {
                    isOk = false;
                }
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
