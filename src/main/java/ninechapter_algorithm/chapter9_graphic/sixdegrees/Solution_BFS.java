package ninechapter_algorithm.chapter9_graphic.sixdegrees;

import type.UndirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/9/16 11:11
 */
public class Solution_BFS {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || graph.size() == 0
                || s == null || t == null) {
            return -1;
        }
        if (s == t) {
            return 0;
        }

        int len = 1;
        int cur = 0;
        int next = 0;
        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(s);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(s);
        cur++;

        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            cur--;
            for (UndirectedGraphNode nn : node.neighbors) {
                if (!visited.contains(nn)) {
                    visited.add(nn);
                    if (nn == t) {
                        return len;
                    } else {
                        queue.add(nn);
                        next++;
                    }
                }
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                len++;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);

        //2, 3 expect 2
//        node2.neighbors.add(node4);
//        node3.neighbors.add(node4);
//        node4.neighbors.add(node2);
//        node4.neighbors.add(node3);

        //1, 4 expect 2
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        ArrayList<UndirectedGraphNode> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);

        Solution_BFS solution_bfs = new Solution_BFS();
        System.out.println(solution_bfs.sixDegrees(graph, node1, node4));
    }
}
