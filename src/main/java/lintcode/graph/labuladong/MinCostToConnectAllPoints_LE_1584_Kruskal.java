package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostToConnectAllPoints_LE_1584_Kruskal {
    /**
     1.31.2023
     - similar to LE 1135, greedy + Kruskal算法
     - ref 东哥 post, 注意需要先build graph, 使用point index
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();
        // init graph, use point index as node number
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi-xj) + Math.abs(yi-yj)});
            }
        }

        // greedy
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        UF uf = new UF(n);
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }

            mst += cost;
            uf.union(u, v);
        }

        return mst;
    }

    class UF {
        int count;
        int[] parent;

        UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        public int getCount() {
            return this.count;
        }
    }
}
