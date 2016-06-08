package ninechapter_algorithm.chapter9_graphic.clonegraph.second;

import type.UndirectedGraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 6/8/16 08:27
 */
public class Solution_DFS {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);

        //1. find all nodes - dfs
        dfs(node, visited);

        //2. copy nodes
        for (UndirectedGraphNode n : visited) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        //3. copy edges
        for (UndirectedGraphNode n : visited) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private void dfs(UndirectedGraphNode node, Set<UndirectedGraphNode> visited) {
        for (UndirectedGraphNode n : node.neighbors) {
            if (!visited.contains(n)) {
                visited.add(n);
                dfs(n, visited);
            }
        }
    }
}
