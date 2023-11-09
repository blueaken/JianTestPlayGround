package lintcode.math.prime;

import java.util.*;

public class Test {

    /**
     11.6.23
     - ref the discussion post and resolve with DFS
     - https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/solutions/4250632/java-dfs-o-n-solution/
     */
    LinkedList<Integer>[] graph;
    int[] values;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        this.values = values;
        int n = edges.length + 1;
        long sum = 0;

        // init graph
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
            sum += values[i];
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        long minSubVal = dfs(0, -1);

        return sum - minSubVal;
//        return dfs(0, -1);
    }

    long dfs(int node, int parent) {
        long res = 0;
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node);
        }

        // leaf node
        if (res == 0) {
            return values[node];
        }

        // return the min of the parent node and sum of child node
        res = Math.min(res, values[node]);
        return res;
    }


    public static void main(String[] args) {
        Test test = new Test();

//        int[][] edges = {{0,1},{0,2}};
//        int[] values = {1,2,3};
//        // 5

//        int[][] edges = {{0,1},{0,2}};
//        int[] values = {5,2,1};
//        // 5

        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values = {5,8,4,3,2,6,7};
        // 30

        System.out.println(test.maximumScoreAfterOperations(edges, values));
    }
}
