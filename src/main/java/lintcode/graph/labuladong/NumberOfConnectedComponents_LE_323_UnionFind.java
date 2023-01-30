package lintcode.graph.labuladong;

public class NumberOfConnectedComponents_LE_323_UnionFind {
    /**
     1.30.2023
     ref 东哥 UF 框架，其实也可以用其他图的遍历做，DFS/BFS都可以
     */
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }
}

class UF {
    private int count;
    private int[] parent;

    // n为节点个数
    UF (int n) {
        this.count = n;
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 联通p和q
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

        return  rootP == rootQ;
    }

    public int getCount() {
        return count;
    }

}
