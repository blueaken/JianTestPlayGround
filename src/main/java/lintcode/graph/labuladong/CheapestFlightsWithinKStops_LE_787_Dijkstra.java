package lintcode.graph.labuladong;

import java.util.*;

public class CheapestFlightsWithinKStops_LE_787_Dijkstra {
    /*
        ref labuladong post
        - solve with TopDown DP with the help of mem cache
        ==========================
        2.3.2023
        solve by Dijkstra, ref 东哥 post
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build adjacent table graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph[from].add(new int[]{to, price});
        }

        // 将stop number转化为边的条数
        k++;
        return dijkstra(graph, src, dst, k);
    }

    class State {
        int id;
        int costFromStart;
        int nodeFromStart;

        State(int id, int costFromStart, int nodeFromStart) {
            this.id = id;
            this.costFromStart = costFromStart;
            this.nodeFromStart = nodeFromStart;
        }
    }

//    // 输入一个起点 src，计算从 src 到其他节点的最短距离
//    int dijkstra(List<int[]>[] graph, int src, int dst, int k) {
//        // 定义：从起点 src 到达节点 i 的最短路径权重为 distTo[i]
//        int[] distTo = new int[graph.length];
//        // 定义：从起点 src 到达节点 i 的最小权重路径至少要经过 nodeNumTo[i] 个节点
//        int[] nodeNumTo = new int[graph.length];
//        Arrays.fill(distTo, Integer.MAX_VALUE);
//        Arrays.fill(nodeNumTo, Integer.MAX_VALUE);
//        // base case
//        distTo[src] = 0;
//        nodeNumTo[src] = 0;
//
//        // 优先级队列，costFromSrc 较小的排在前面
//        Queue<State> pq = new PriorityQueue<>((a, b) -> {
//            return a.costFromStart - b.costFromStart;
//        });
//        // 从起点 src 开始进行 BFS
//        pq.offer(new State(src, 0, 0));
//
//        while (!pq.isEmpty()) {
//            State curState = pq.poll();
//            int curNodeID = curState.id;
//            int costFromSrc = curState.costFromStart;
//            int curNodeNumFromSrc = curState.nodeFromStart;
//
//            if (curNodeID == dst) {
//                // 找到最短路径
//                return costFromSrc;
//            }
//            if (curNodeNumFromSrc == k) {
//                // 中转次数耗尽
//                continue;
//            }
//
//            // 将 curNode 的相邻节点装入队列
//            for (int[] neighbor : graph[curNodeID]) {
//                int nextNodeID = neighbor[0];
//                int costToNextNode = costFromSrc + neighbor[1];
//                // 中转次数消耗 1
//                int nextNodeNumFromSrc = curNodeNumFromSrc + 1;
//
//                // 更新 dp table
//                if (distTo[nextNodeID] > costToNextNode) {
//                    distTo[nextNodeID] = costToNextNode;
//                    nodeNumTo[nextNodeID] = nextNodeNumFromSrc;
////                    pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
//                }
//                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
//                if (costToNextNode > distTo[nextNodeID]
//                        && nextNodeNumFromSrc > nodeNumTo[nextNodeID]) {
//                    continue;
//                }
//
//                pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
//            }
//        }
//        return -1;
//    }

    private int dijkstra(List<int[]>[] graph, int start, int end, int nodeNum) {
        int n = graph.length;
        int[] costTo = new int[n];
        int[] nodeTo = new int[n];
        // inti the array with max value since we are looking for min cost
        Arrays.fill(costTo, Integer.MAX_VALUE);
        Arrays.fill(nodeTo, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.costFromStart - b.costFromStart);
        // base case
        costTo[start] = 0;
        nodeTo[start] = 0;
        pq.offer(new State(start, 0, 0));

        while (pq.size() > 0) {
            State cur = pq.poll();
            int curId = cur.id;
            int curCostFromStart = cur.costFromStart;
            int curNodeFromStart = cur.nodeFromStart;

            if (curId == end) {
                return curCostFromStart;
            }

            // 中转次数耗尽则放弃当前路径, 注意此时如果存在cost更小的路径不要放弃，因为存在这条cost更小路径由于中转次数原因被放弃可能
            if (curNodeFromStart == nodeNum) {
                continue;
            }

            /**
             // 将 curNode 的相邻节点装入队列
             //            for (int[] neighbor : graph[curNodeID]) {
             //                int nextNodeID = neighbor[0];
             //                int costToNextNode = costFromSrc + neighbor[1];
             //                // 中转次数消耗 1
             //                int nextNodeNumFromSrc = curNodeNumFromSrc + 1;
             //
             //                // 更新 dp table
             //                if (distTo[nextNodeID] > costToNextNode) {
             //                    distTo[nextNodeID] = costToNextNode;
             //                    nodeNumTo[nextNodeID] = nextNodeNumFromSrc;
             ////                    pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
             //                }
             //                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
             //                if (costToNextNode > distTo[nextNodeID]
             //                        && nextNodeNumFromSrc > nodeNumTo[nextNodeID]) {
             //                    continue;
             //                }
             //
             //                pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
             //            }
             */

            for (int[] next : graph[curId]) {
                int nextId = next[0];
                // 注意这里不能用costTo[curId]计算到nextId的cost，因为这里可能会包括因为中转次数被放弃的路径值，使用State存储的信息为主
                // int nextCostFromStart = costTo[curId] + nextCost;
                int nextCostFromStart = curCostFromStart + next[1];
                int nextNodeFromStart = curNodeFromStart + 1;

                if (costTo[nextId] > nextCostFromStart) {
                    costTo[nextId] = nextCostFromStart;
                    nodeTo[nextId] = nextNodeFromStart; // 中转次数加1;
//                    pq.offer(new State(nextId, nextCostFromStart, nextNodeFromStart));
                }

                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
                if (nextCostFromStart > costTo[nextId]
                        && nextNodeFromStart > nodeTo[nextId]) {
                    continue;
                }

                pq.offer(new State(nextId, nextCostFromStart, nextNodeFromStart));
            }
        }
        // return -1 if not reachable
        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops_LE_787_Dijkstra solution = new CheapestFlightsWithinKStops_LE_787_Dijkstra();
//        int n = 4;
//        int src = 0;
//        int dst = 3;
//        int k = 1;
//        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
//        // 6

        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        // 7

        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));
    }
}
