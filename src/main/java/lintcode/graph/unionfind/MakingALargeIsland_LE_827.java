package lintcode.graph.unionfind;

import java.util.*;
public class MakingALargeIsland_LE_827 {
    /**
     11.20.23
     - try union find
     - ref solution - https://leetcode.com/problems/making-a-large-island/solutions/210176/java-union-find/
     */
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(m*n);
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        int res = 0;
        // union around all 1s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int newI = i + dirs[k][0];
                        int newJ = j + dirs[k][1];

                        if (isValid(grid, newI, newJ) && grid[newI][newJ] == 1) {
                            uf.union(i*n+j, newI*n+newJ);
                        }
                    }
                }
            }
        }
        res = uf.getMaxSize();

        // check each 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> parents = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newI = i + dirs[k][0];
                        int newJ = j + dirs[k][1];

                        if (isValid(grid, newI, newJ) && grid[newI][newJ] == 1) {
                            parents.add(uf.find(newI*n+newJ));
                        }
                    }

                    // update maxSize if needed
                    int size = 0;
                    for (int parent : parents) {
                        size += uf.getParentSize(parent);
                    }
                    res = Math.max(res, 1 + size);
                }

            }
        }

        return res;
    }

    boolean isValid(int[][]grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static void main(String[] args) {
        MakingALargeIsland_LE_827 solution = new MakingALargeIsland_LE_827();
        int[][] grid = {{0,1}, {1,0}}; //3
        System.out.println(solution.largestIsland(grid));
    }

    class UF {
        int[] parent;
        int count;
        int[] size;
        int maxSize;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            count = n;
            maxSize = 1;
        }

        int find(int x) {
            if (x != parent[x]) {
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

            size[rootQ] += size[rootP];
            maxSize = Math.max(maxSize, size[rootQ]);
        }

        boolean isConnect(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        int getMaxSize(){
            return maxSize;
        }

        int getParentSize(int parent) {
            return size[parent];
        }

    }
}
