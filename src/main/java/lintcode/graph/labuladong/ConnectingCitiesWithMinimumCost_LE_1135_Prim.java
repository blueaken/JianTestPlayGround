package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost_LE_1135_Prim {
    /**
     1.31.2023
     - Greedy + Kruskal算法，ref 东哥 post
     - similar to LE 261
     - 你可以认为树的判定算法加上按权重排序的逻辑就变成了 Kruskal 算法
     ===============================================================
     2.1.2023
     - Try Prim算法，ref 东哥 post
     - note Prim算法模板node从0开始，本题的label是从1开始，buildGraph时需要先转化
     */
    public int minimumCost(int n, int[][] connections) {
        // build graph to adjacent list
        List<int[]>[] graph = buildGraph(n, connections);

        Prim prim = new Prim(graph);

        if (!prim.allConnected()) {
            return -1;
        }

        return prim.getWeightSum();
    }

    class Prim {
        // 存储横切边数据结构，按照权重从小到大排序
        PriorityQueue<int[]> pq;
        // 类似visited数组，纪录哪些结点已经成为MST的一部分
        boolean[] inMST;
        // 纪录整体weight和
        int weightSum =0;
        // 三元组{from, to, weight}构成的graph邻接表
        List<int[]>[] graph;

        Prim(List<int[]>[] graph) {
            this.graph = graph;
            this.pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

            int n = graph.length;
            this.inMST = new boolean[n];

            // can start from any node, let's start from 0
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

        // 将node的邻接边加入优先队列
        private void cut(int node) {
            for (int[] edge : this.graph[node]) {
                int to = edge[1];
                if (this.inMST[to]) {
                    continue;
                }
                pq.offer(edge);
            }
        }

        public int getWeightSum() {
            return this.weightSum;
        }

        public boolean allConnected() {
            for (int i = 0; i < inMST.length; i++) {
                if (!inMST[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int cost = edge[2];
            graph[u].add(new int[] {u, v, cost});
            graph[v].add(new int[] {v, u, cost});
        }
        return graph;
    }
}
