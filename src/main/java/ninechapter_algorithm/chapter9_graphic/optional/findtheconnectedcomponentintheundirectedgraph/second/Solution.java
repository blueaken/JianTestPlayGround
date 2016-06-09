package ninechapter_algorithm.chapter9_graphic.optional.findtheconnectedcomponentintheundirectedgraph.second;

import type.UndirectedGraphNode;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/9/16 15:00
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }

        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        for (UndirectedGraphNode gn : nodes) {
            //bfs
            if (!visited.contains(gn)) {
                List<Integer> list = new ArrayList<>();
                queue.offer(gn);
                visited.add(gn);
                list.add(gn.label);

                while (!queue.isEmpty()) {
                    UndirectedGraphNode node = queue.poll();
                    for (UndirectedGraphNode nn : node.neighbors) {
                        if (!visited.contains(nn)) {
                            visited.add(nn);
                            queue.offer(nn);
                            list.add(nn.label);
                        }
                    }
                }
                Collections.sort(list);
                result.add(list);
            }

        }
        return result;
    }
}
