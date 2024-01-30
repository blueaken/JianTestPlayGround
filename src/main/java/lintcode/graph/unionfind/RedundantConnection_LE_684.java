package lintcode.graph.unionfind;

public class RedundantConnection_LE_684 {
    /**
     1.30.24
     - classic Union Find problem
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
            } else {
                return edge;
            }
        }
        return new int[] {};
    }

    class UF {
        int[] parent;
        int count;

        UF(int n) {
            parent = new int[n+1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            parent[rootP] = rootQ;
            count--;
        }
    }
}
