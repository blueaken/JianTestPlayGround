package lintcode.graph.labuladong;

public class IsGraphBipartite_LE_785 {
    /**
     1.30.2023
     ref 东哥 图DFS框架
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
                traverse(graph, i);
            }
        }
        return isOk;
    }

    private void traverse(int[][] graph, int node) {
        if (!isOk) {
            return;
        }

        visited[node] = true;
        for (int neigh : graph[node]) {
            if (!visited[neigh]) {
                // if neighbor not visited, then set its color diff from the current node
                color[neigh] = !color[node];
                // continue dfs
                traverse(graph, neigh);
            } else {
                if (color[neigh] == color[node]) {
                    isOk = false;
                    return;
                }
            }
        }
    }
}
