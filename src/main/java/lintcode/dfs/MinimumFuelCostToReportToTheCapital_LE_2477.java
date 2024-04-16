package lintcode.dfs;

import java.util.List;
import java.util.ArrayList;

public class MinimumFuelCostToReportToTheCapital_LE_2477 {
    /**
     2.11.24
     - dfs
     ref https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/solutions/3173765/clean-codes-full-explanation-dfs-c-java-python3/
     */

    long fuel = 0; int seats;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        if (n == 1) {
            return 0;
        }

        this.seats = seats;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        dfs(0, -1, graph);
        return fuel;
    }

    // return the number of people from prev to cur
    int dfs(int cur, int prev, List<Integer>[] graph) {
        int people = 1;
        for (int neigh : graph[cur]) {
            if (neigh == prev) {
                continue;
            }
            people += dfs(neigh, cur, graph);
        }
        if (cur > 0) {
            fuel += (int)Math.ceil((double)people/seats);
        }
        return people;
    }

    public static void main(String[] args) {
        MinimumFuelCostToReportToTheCapital_LE_2477 solution = new MinimumFuelCostToReportToTheCapital_LE_2477();
        System.out.println(solution.minimumFuelCost(new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));
    }
}

