package lintcode.graph;

import type.UndirectedGraphNode;

import java.util.*;

public class CloneGraph_LE_133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        //get the whole nodes via bfs
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.add(node);
        queue.offer(node);

        while (queue.size() > 0) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        //first copy nodes
        for (UndirectedGraphNode n : visited) {
            if (!map.containsKey(n)) {
                map.put(n, new UndirectedGraphNode(n.label));
            }
        }
        //then copy edges
        for (UndirectedGraphNode n : visited) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
