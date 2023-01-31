package lintcode.graph.labuladong;

public class GraphValidTree_LE_261 {
    /**
     1.31.2023
     easier to solve by Union Find, ref 东哥 post
     */
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.connected(u, v)) {
                return false;
            }
            uf.union(u, v);
        }

        return uf.getCount() == 1;
    }

    class UF{
        int count;
        int[] parent;

        UF(int n) {
            this.count = n;
            this.parent = new int[n];
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
