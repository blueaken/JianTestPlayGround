package lintcode.dynamicprogramming2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheapestFlightsWithinKStops_LE_787_P1 {
    /*
        ref labuladong post
        - solve with TopDown DP with the help of mem cache
        ==========================
        2.3.2023
        solve by Dijkstra, ref 东哥 post
        ==========================
        2.3.2023
        - TopDown DP P1
    */

    List<int[]>[] graph;
    int src, dst;
    int[][] memo; // memo array for top down dp

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build adjacent table indegree graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph[to].add(new int[]{from, price});
        }
        this.graph = graph;
        this.src = src;
        this.dst = dst;

        // 将stop number转化为边的条数
        k++;
        memo = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -888);
        }
        return dp(dst, k);
    }

    // 定义：从 src 出发，k 步之内到达 s 的最小成本
    private int dp(int s, int k) {
        // base case
        if (s == src) {
            return 0;
        }
        // 中转次数消耗殆尽，返回-1
        if (k == 0) {
            return -1;
        }

        if (memo[s][k] != -888) {
            return memo[s][k];
        }

        int res = Integer.MAX_VALUE;
        if (graph[s].size() > 0) {
            for (int[] edge : graph[s]) {
                int from = edge[0];
                int price = edge[1];
                int subProblem = dp(from, k-1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }

        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops_LE_787_P1 solution = new CheapestFlightsWithinKStops_LE_787_P1();

//        int n = 4;
//        int src = 0;
//        int dst = 3;
//        int k = 1;
//        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        // 6

//        int n = 5;
//        int src = 0;
//        int dst = 2;
//        int k = 2;
//        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
//        // 7

        int n = 5;
        int src = 2;
        int dst = 1;
        int k = 1;
        int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        // -1

        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));
    }
}
