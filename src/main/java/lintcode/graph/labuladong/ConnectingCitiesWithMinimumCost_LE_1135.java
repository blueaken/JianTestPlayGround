package lintcode.graph.labuladong;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost_LE_1135 {
    /**
     1.31.2023
     - Greedy + Kruskal算法，ref 东哥 post
     - similar to LE 261
     */
    public int minimumCost(int n, int[][] connections) {
        // label starts from 1
        UF uf = new UF(n+1);

        // sort the edges on the weight - Greedy
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], cost = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }

            mst += cost;
            uf.union(u, v);
        }

        // UF count should be 1 after the MST spanning, but since the label starts from 1, need to add node 0's count
        return uf.getCount() == 2 ? mst : -1;
    }

    class UF {
        int count = 0;
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
