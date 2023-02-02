package lintcode.graph.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime_LE_743 {
    /**
     2.2.2023
     Dijkstra算法, ref 东哥 post
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildGraph(n, times);

        int[] distTo = dijkstra(k, graph);

        // 找出最长的一条路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回-1
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    private List<int[]>[] buildGraph(int n, int[][] times) {
        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from].add(new int[] {to, weight});
        }
        return graph;
    }

    class State {
        // 图节点Id
        int id;
        // 从start节点到当前节点的距离
        int distFromStart;

        State(int id, int disFromStart) {
            this.id = id;
            this.distFromStart = disFromStart;
        }
    }

    int[] dijkstra(int start, List<int[]>[] graph) {
        // n为图中节点个数
        int n = graph.length;
        // distTo[i] 定义为从start节点到i节点最小距离
        int[] distTo = new int[n];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case
        distTo[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        pq.offer(new State(start, 0));

        while (pq.size() > 0) {
            State cur = pq.poll();
            int curId = cur.id;
            int curDistFromStart = cur.distFromStart;

            // 如果已存在一条更短路径
            if (curDistFromStart > distTo[curId]) {
                continue;
            }

            // 否则更新curId节点的相邻节点
            // distTo[curId] = curDistFromStart; // 注：这句可以注释，因为在加入pq时已经处理过，此时已经相等
            for (int[] neigh : graph[curId]) {
                int neighId = neigh[0];
                int neighDist = neigh[1];
                int distToNeigh = distTo[curId] + neighDist;

                if (distTo[neighId] > distToNeigh) {
                    distTo[neighId] = distToNeigh;
                    pq.offer(new State(neighId, distToNeigh));
                }
            }
        }
        return distTo;
    }
}
