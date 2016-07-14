package leetcode.algorithm.medium.clonegraph;

import type.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 10/18/15 1:03 AM
 */
public class Solution {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfsRec(node, map);
    }

    static UndirectedGraphNode dfsRec(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if (map.get(node)!=null){
            return map.get(node);
        }
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        for (UndirectedGraphNode graphNode : node.neighbors){
            nodeCopy.neighbors.add(dfsRec(graphNode, map));
        }
        return  nodeCopy;
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
