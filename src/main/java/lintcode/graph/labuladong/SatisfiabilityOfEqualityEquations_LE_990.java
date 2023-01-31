package lintcode.graph.labuladong;

public class SatisfiabilityOfEqualityEquations_LE_990 {
    /**
     1.31.2023
     class union find problem, ref 东哥 post
     */
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x-'a', y-'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x-'a', y-'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    class UF {
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
