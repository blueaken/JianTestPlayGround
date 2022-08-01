package lintcode.graph;

import java.util.*;

public class ConnectionsWithMinCost_LE_1135 {
    /*
        - ref LeetCode Minimum Spanning Tree Study Guide - https://leetcode.com/discuss/study-guide/1131969/Minimum-Spanning-Tree-beginner's-guide
        - ref 花花酱 video about Minimum Spanning Tree & Prim's algorithm - https://www.youtube.com/watch?v=wmW8G8SrXDs (the Prim's algorithm described are different than the above link)
        Step 1. build the graph with adjacent list
        Step 2. init a MST set and a random node, usually pick Node 0
        Step 3. put all edges of the node into a min heap, on the value of the edge weight
        Step 4. pop the edge with the least weight and if the node of the other side is not in the set then add the node, keep adding weight in this procss
        Step 5. repeat Step 3. & Step 4. until all nodes are in the set
        Step 6. output the added weight
    */

    Map<Integer, List<int[]>> graph = new HashMap<>();
    int ans;

    public int minimumCost(int n, int[][] connections) {
        //init the adjacent list style bidirectional graph
        for (int i = 1; i <= n; i++) {
            this.graph.put(i, new ArrayList<>());
        }
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], weight = edge[2];
            int[] e1 = new int[] {v, weight};
            this.graph.get(u).add(e1);

            int[] e2 = new int[] {u, weight};
            this.graph.get(v).add(e2);
        }

        Set<Integer> mst = new HashSet<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1)); //v, weight, order by weight
        queue.offer(Arrays.asList(1, 0));//v, weight
        while (mst.size() != n) {
            if (queue.size() == 0) {
                //if queue size is 0, indicates not enough edges to connect all nodes
                return -1;
            }
            List<Integer> cur = queue.poll();
            int node = cur.get(0);
            int cost = cur.get(1);
            if (mst.contains(node)) {
                continue;
            }
            mst.add(node);
            ans += cost;
            for (int[] neighbor : this.graph.get(node)) {
                int neighborNode = neighbor[0], neighborCost = neighbor[1];
                if (mst.contains(neighborNode)) {
                    continue;
                }
                queue.offer(Arrays.asList(neighborNode, neighborCost)); //v, weight
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ConnectionsWithMinCost_LE_1135 solution = new ConnectionsWithMinCost_LE_1135();
//        int n = 3;
//        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
//        //6

        int n = 4;
        int[][] connections = {{1,2,3},{3,4,4}};
        //-1

        System.out.println(solution.minimumCost(n, connections));
    }
}
