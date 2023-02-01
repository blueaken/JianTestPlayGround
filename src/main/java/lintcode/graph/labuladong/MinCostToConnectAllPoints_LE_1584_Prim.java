package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints_LE_1584_Prim {
    /**
     1.31.2023
     - similar to LE 1135, greedy + Kruskai算法
     - ref 东哥 post, 注意需要先build graph, 使用point index
     ========================================================
     2.1.2023
     - Solve with Prim算法，ref 东哥 post
     */
    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = buildGraph(points);

        Prim prim = new Prim(graph);
        return prim.getWeightSum();
    }

    class Prim {
        List<int[]>[] graph;
        PriorityQueue<int[]> pq;
        boolean[] inMST;
        int weightSum = 0;

        Prim(List<int[]>[] graph) {
            this.graph = graph;
            pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
            int n = graph.length;
            inMST = new boolean[n];

            // start cur from node 0
            inMST[0] = true;
            cut(0);

            while (pq.size() > 0) {
                int[] edge = pq.poll();
                int to = edge[1];
                int weight = edge[2];

                if (inMST[to]) {
                    continue;
                }
                inMST[to] = true;
                weightSum += weight;
                cut(to);
            }
        }

        public void cut(int node) {
            for (int[] edge : graph[node]) {
                int to = edge[1];
                if (inMST[to]) {
                    continue;
                }
                this.pq.offer(edge);
            }
        }

        public boolean allConnected() {
            for (int i = 0; i < inMST.length; i++) {
                if (!inMST[i]) {
                    return false;
                }
            }
            return true;
        }

        public int getWeightSum() {
            return this.weightSum;
        }
    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int dis = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph[i].add(new int[] {i, j, dis});
                graph[j].add(new int[] {j, i, dis});
            }
        }
        return graph;
    }
}
