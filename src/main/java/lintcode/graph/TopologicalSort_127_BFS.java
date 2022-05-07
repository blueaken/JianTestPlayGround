package lintcode.graph;

import type.DirectedGraphNode;

import java.util.*;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

/*
    DFS solution, ref - https://www.youtube.com/watch?v=ddTC4Zovtbc,
    DFS usually TLE for graph problem, checking previous notes, try BFS with indegree count
    Usage - 用于编译或工作排序系统
*/
public class TopologicalSort_127_BFS {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        //count indegree for each node
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        //init start node into queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }

        //explore the graph from start node(s)
        while (queue.size() > 0) {
            DirectedGraphNode cur = queue.poll();
            res.add(cur);
            for (DirectedGraphNode neighbor : cur.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return res;
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

        TopologicalSort_127_BFS solution = new TopologicalSort_127_BFS();
        solution.topSort(graph);
    }
}
