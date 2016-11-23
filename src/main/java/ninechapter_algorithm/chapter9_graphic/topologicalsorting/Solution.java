package ninechapter_algorithm.chapter9_graphic.topologicalsorting;

import type.DirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/4/16 14:42
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null) {
            return result;
        }

        Map<DirectedGraphNode, Integer> indgree = new HashMap<>();
        for (DirectedGraphNode graphNode : graph) {
            for (DirectedGraphNode neighbor : graphNode.neighbors) {
                if (indgree.containsKey(neighbor)) {
                    indgree.put(neighbor, indgree.get(neighbor) + 1);
                } else {
                    indgree.put(neighbor, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode graphNode : graph) {
            if (!indgree.containsKey(graphNode)) {
                queue.offer(graphNode);
                result.add(graphNode);
            }
        }

        //bfs on queue nodes
        while (queue.size() > 0) {
            DirectedGraphNode cur = queue.poll();
            for (DirectedGraphNode neighbor : cur.neighbors) {
                indgree.put(neighbor, indgree.get(neighbor) - 1);
                if (indgree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DirectedGraphNode node0 = new DirectedGraphNode(0);
        DirectedGraphNode node1 = new DirectedGraphNode(1);
        DirectedGraphNode node2 = new DirectedGraphNode(2);
        DirectedGraphNode node3 = new DirectedGraphNode(3);
        DirectedGraphNode node4 = new DirectedGraphNode(4);
        DirectedGraphNode node5 = new DirectedGraphNode(5);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node0.neighbors.add(node3);

        node1.neighbors.add(node4);
        node2.neighbors.add(node4);
        node2.neighbors.add(node5);
        node3.neighbors.add(node4);
        node3.neighbors.add(node5);

        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);

        topSort(graph);
    }
}
