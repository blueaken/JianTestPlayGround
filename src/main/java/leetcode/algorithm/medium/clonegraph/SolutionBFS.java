package leetcode.algorithm.medium.clonegraph;

import type.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 10/18/15 1:29 AM
 */
public class SolutionBFS {
    //bfs - why?
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);

        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            for (UndirectedGraphNode neighbor : current.neighbors){
                if (map.containsKey(neighbor)){
                    map.get(current).neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    map.get(current).neighbors.add(neighborCopy);
                    queue.add(neighbor);
                }
            }
        }
        return nodeCopy;
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
