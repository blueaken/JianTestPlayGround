package lintcode.graph.labuladong;

public class SurroundedRegions_LE_130 {
    /**
     1.31.2023
     an island problem, but can be soled with Union Find as well, ref 东哥 post
     */
    public void solve(char[][] board) {
        // convert 2d array index to 1d array index - idx = i * n + y, n is the col number
        int m = board.length, n = board[0].length;
        UF uf = new UF(m*n + 1); //create a dummy parent (idx m*n) for all remainings 'O's
        int dummy = m*n;

        // union 1st and last column 'O's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i*n, dummy);
            }
            if (board[i][n-1] == 'O') {
                uf.union((i*n + n-1), dummy);
            }
        }
        // union 1st and last row 'O's
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy);
            }
            if (board[m-1][j] == 'O') {
                uf.union(((m-1)*n + j), dummy);
            }
        }

        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(i*n+j, x*n+y);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!uf.connected(dummy, i*n+j)) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    class UF {
        int count;
        int[] parent;

        UF (int n) {
            this.count = n;
            parent = new int[n];
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


