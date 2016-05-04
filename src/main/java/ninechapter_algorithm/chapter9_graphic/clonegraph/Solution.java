package ninechapter_algorithm.chapter9_graphic.clonegraph;

import type.UndirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/4/16 10:49
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);

        //1. find all nodes
        while(queue.size() > 0) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode graphNode : cur.neighbors) {
                if (!visited.contains(graphNode)) {
                    queue.offer(graphNode);
                    visited.add(graphNode);
                }
            }
        }

        //2. copy all nodes - similar to clone random linkedlist
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode graphNode : visited) {
            UndirectedGraphNode newGraphNode = new UndirectedGraphNode(graphNode.label);
            map.put(graphNode, newGraphNode);
        }

        //3. copy all edges
        for (UndirectedGraphNode graphNode : visited) {
            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                map.get(graphNode).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public static void main(String[] args){
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);

        node1.neighbors.add(node0);
        node1.neighbors.add(node2);

        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        node2.neighbors.add(node2);

        UndirectedGraphNode node0Copy = cloneGraph(node0);
        System.out.println(node0Copy.label);
    }
}
