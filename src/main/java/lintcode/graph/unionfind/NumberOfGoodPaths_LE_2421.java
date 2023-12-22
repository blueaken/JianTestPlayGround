package lintcode.graph.unionfind;

import java.util.*;

public class NumberOfGoodPaths_LE_2421 {

    /**
     12.22.23
     ref Huifeng Guan video - https://www.youtube.com/watch?v=-cIIQPdL404
     */
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        if (n == 1) {
            return 1;
        }

        // init
        UF uf = new UF(n);
        Map<Integer, List<Integer>> val2Idxs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            val2Idxs.putIfAbsent(vals[i], new ArrayList<>());
            val2Idxs.get(vals[i]).add(i);;
        }

        // build graph, key is node value, edge is from current node to node with less or equal value node
        TreeMap<Integer, List<int[]>> graph = new TreeMap<>(); // tree map sort the values by default
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            // make sure From Node value is bigger or equal than To Node
            if (vals[from] < vals[to]) {
                int temp = from;
                from = to;
                to = temp;
            }
            graph.putIfAbsent(vals[from], new ArrayList<>());
            graph.get(vals[from]).add(new int[] {from, to});
        }

        int res = 0;
        for (Integer val : graph.keySet()) {
            for (int[] edge : graph.get(val)) {
                int from = edge[0], to = edge[1];
                if (uf.find(from) != uf.find(to)) {
                    uf.union(from, to);
                }
            }

            Map<Integer, Integer> count = new HashMap<>();
            for (Integer idx : val2Idxs.get(val)) {
                int curRoot = uf.find(idx);
                count.put(curRoot, count.getOrDefault(curRoot, 0) + 1);
            }

            for (Integer key : count.keySet()) {
                int curNodeCount = count.get(key);
                // math calculation
                res += (curNodeCount * (curNodeCount-1)) / 2;
            }
        }

        // add single node paths to the result
        return res + n;
    }

    class UF {
        int[] parent;
        int count;

        UF(int n) {
            this.count = n;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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

        boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

    }

    public static void main(String[] args) {
        NumberOfGoodPaths_LE_2421 solution = new NumberOfGoodPaths_LE_2421();
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        // 6

//        int[] vals = {1,1,2,2,3};
//        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {2, 4}};
        // 9

        System.out.println(solution.numberOfGoodPaths(vals, edges));
    }
}
