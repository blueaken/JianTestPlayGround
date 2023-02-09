package lintcode.graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumDegreeOfConnectedTrioInGraph_LE_1761 {
    /**
     2.9.2023
     - 构建邻接表，同时用邻接矩阵和 degree array 来提高循环效率
     */
    public int minTrioDegree(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] degree = new int[n+1];
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);

            degree[u]++;
            degree[v]++;

            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            List<Integer> neighs = graph[i];
            if (neighs.size() > 1) {
                for (int j = 0; j < neighs.size(); j++) {
                    for (int k = j+1; k < neighs.size(); k++) {
                        int b = neighs.get(j), c = neighs.get(k);
                        if (matrix[b][c] == 1) {
                            int cur = degree[i] + degree[b] + degree[c] - 6;
                            res = Math.min(res, cur);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        MinimumDegreeOfConnectedTrioInGraph_LE_1761 solution = new MinimumDegreeOfConnectedTrioInGraph_LE_1761();
        int n = 3;
        int[][] edges = {{3,2},{2,1}};
        System.out.println(solution.minTrioDegree(n, edges));
    }
}
