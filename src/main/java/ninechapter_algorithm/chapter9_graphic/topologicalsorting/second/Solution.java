package ninechapter_algorithm.chapter9_graphic.topologicalsorting.second;

import type.DirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/9/16 09:21
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return result;
        }

        //build indgree map
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode gn : graph) {
            for (DirectedGraphNode nn : gn.neighbors) {
                if (indegree.containsKey(nn)) {
                    indegree.put(nn, indegree.get(nn) + 1);
                } else {
                    indegree.put(nn, 1);
                }
            }
        }

        //find node with indegree 0
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode gn : graph) {
            if (!indegree.containsKey(gn)) {
                queue.offer(gn);
                result.add(gn);
            }
        }

        //bfs
        while (queue.size() > 0) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode nn : node.neighbors) {
                int val = indegree.get(nn) - 1;
                indegree.put(nn, val);
                if (val == 0) {
                    queue.offer(nn);
                    result.add(nn);
                }
            }
        }
        return result;
    }
}
