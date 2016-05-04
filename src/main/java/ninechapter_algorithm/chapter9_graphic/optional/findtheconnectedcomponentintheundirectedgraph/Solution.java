package ninechapter_algorithm.chapter9_graphic.optional.findtheconnectedcomponentintheundirectedgraph;

import type.UndirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/4/16 15:49
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }

        Set<UndirectedGraphNode> visited = new HashSet<>();
        for (UndirectedGraphNode node: nodes) {
            if (!visited.contains(node)) {
                //bfs
                List<Integer> connect = new ArrayList<>();
                Queue<UndirectedGraphNode> queue = new LinkedList<>();
                queue.offer(node);
                visited.add(node);
                connect.add(node.label);

                while (queue.size() > 0) {
                    UndirectedGraphNode cur = queue.poll();
                    for (UndirectedGraphNode n: cur.neighbors) {
                        if (!visited.contains(n)) {
                            connect.add(n.label);
                            queue.offer(n);
                            visited.add(n);
                        }
                    }
                }
                Collections.sort(connect);
                result.add(connect);
            }
        }
        return result;
    }

    public static void main(String[] args){
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node4);

        node3.neighbors.add(node5);

        node4.neighbors.add(node1);
        node4.neighbors.add(node2);

        node5.neighbors.add(node3);

        ArrayList<UndirectedGraphNode> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);
        graph.add(node5);

        System.out.println(connectedSet(graph));
    }
}
