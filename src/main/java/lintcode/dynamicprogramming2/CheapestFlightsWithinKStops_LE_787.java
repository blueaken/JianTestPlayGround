package lintcode.dynamicprogramming2;

import java.util.*;


public class CheapestFlightsWithinKStops_LE_787 {
    /*
        ref labuladong post
        - solve with TopDown DP with the help of mem cache
    */
    Map<Integer, List<int[]>> indegree;
    int src, dst;

    int[][] mem;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.src = src;
        this.dst = dst;
        indegree = new HashMap<>();

        int flightTimeLimit = k + 1;
        mem = new int[n][flightTimeLimit + 1];

        for (int[] row : mem) {
            Arrays.fill(row, -888);
        }

        //build indegree map
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            indegree.putIfAbsent(v, new ArrayList<>());
            indegree.get(v).add(new int[] {u, price});
        }

        //dp定义为从起点 src 出发，flightTimeLimit步之内（一步就是一条边）到达节点 s 的最小价格为 dp(s, flightTimes)
        return dp(dst, flightTimeLimit);
    }

    private int dp(int s, int flightTimeLimit) {
        //base case
        if (s == src) {
            return 0;
        }
        //case when used out flightTimeLimit
        if (flightTimeLimit == 0) {
            return -1;
        }

        if (mem[s][flightTimeLimit] != -888) {
            return mem[s][flightTimeLimit];
        }

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            for (int[] indegreeInfo : indegree.get(s)) {
                int u = indegreeInfo[0];
                int price = indegreeInfo[1];
                int sub = dp(u, flightTimeLimit -1);
                //skip unreachable route
                if (sub == -1) {
                    continue;
                }
                res = Math.min(res, sub + price);
            }
        }
        mem[s][flightTimeLimit] = res == Integer.MAX_VALUE ? -1 : res;
        return mem[s][flightTimeLimit];
    }
}
