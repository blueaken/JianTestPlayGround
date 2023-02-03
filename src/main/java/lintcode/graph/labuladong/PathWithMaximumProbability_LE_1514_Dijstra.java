package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability_LE_1514_Dijstra {
    /**
     2.2.2023
     Dijstra算法，ref 东哥 post
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // build adjacent graph from input
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];

            graph[from].add(new double[] {(double)to, prob});
            graph[to].add(new double[] {(double)from, prob});
        }

        return dijstra(graph, start, end);
    }

    private double dijstra(List<double[]>[] graph, int start, int end) {
        int n = graph.length;
        // probTo[i]定义为从start到i的最大prob
        double[] probTo = new double[n];

        Arrays.fill(probTo, -1);
        // base case
        probTo[start] = 1;

        // 按照最大概率从大到小排列
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });
        pq.offer(new State(start, 1));

        while (pq.size() > 0) {
            State cur = pq.poll();
            int curId = cur.id;
            double curProbFromStart = cur.probFromStart;

            if (curId == end) {
                return curProbFromStart;
            }

            // 如果存在一条概率更大的路径，返回
            if (curProbFromStart < probTo[curId]) {
                continue;
            }

            for (double[] next : graph[curId]) {
                int nextId = (int)next[0];
                double nextProb = next[1];
                double nextProbFromStart = probTo[curId] * nextProb;

                if (nextProbFromStart > probTo[nextId]) {
                    probTo[nextId] = nextProbFromStart;
                    pq.offer(new State(nextId, nextProbFromStart));
                }
            }
        }

        // 如果到达不了end，返回0
        return 0.00;
    }

    class State {
        int id;
        double probFromStart;

        State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }
}
