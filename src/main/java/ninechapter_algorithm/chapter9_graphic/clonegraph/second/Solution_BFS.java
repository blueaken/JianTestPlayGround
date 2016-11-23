package ninechapter_algorithm.chapter9_graphic.clonegraph.second;

import type.UndirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/8/16 07:23
 */
public class Solution_BFS {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        //bfs find all nodes
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.add(node);
        queue.offer(node);
        while (queue.size() > 0) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode graphNode : cur.neighbors) {
                if (!visited.contains(graphNode)) {
                    queue.offer(graphNode);
                    visited.add(graphNode);
                }
            }
        }

        //copy nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode graphNode : visited) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(graphNode.label);
            map.put(graphNode, newNode);
        }

        //copy edges
        for (UndirectedGraphNode graphNode : visited) {
            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                map.get(graphNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
