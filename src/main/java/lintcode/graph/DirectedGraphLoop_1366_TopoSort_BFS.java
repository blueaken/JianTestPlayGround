package lintcode.graph;

import java.util.*;

public class DirectedGraphLoop_1366_TopoSort_BFS {
    /**
     * @param start: The start points set
     * @param end: The end points set
     * @return: Return if the graph is cyclic
     */
     /*
        Ref - https://www.youtube.com/watch?v=rKQaZuoUR4M, but TLE, try topo sort BFS solution, DFS TLE
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Set<Integer> wholeSet = new HashSet<>();

        //build the node set
        for (Integer i : start) {
            wholeSet.add(i);
        }
        for (Integer i : end) {
            wholeSet.add(i);
        }

        //count the indegree map
        Map<Integer, Integer> indegree = new HashMap<>();
        for (Integer node : wholeSet) {
            //find neighbors
            Set<Integer> curNeighbors = findNeighbors(node, start, end);
            for (Integer neighbor : curNeighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        //init start node
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : wholeSet) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }

        //explore the map with BFS
        while (queue.size() > 0) {
            Integer cur = queue.poll();
            res.add(cur);
            //find cur neighbors
            Set<Integer> curNeighbors = findNeighbors(cur, start, end);

            for (Integer neighbor : curNeighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        //if a cycle exists, topo sort cannot traverse the whole map
        return res.size() != wholeSet.size();
    }

    private Set<Integer> findNeighbors(Integer node, int[] start, int[] end) {
        Set<Integer> curNeighbors = new HashSet<>();
        for (int i = 0; i < start.length; i++) {
            if (start[i] == node) {
                curNeighbors.add(end[i]);
            }
        }
        return curNeighbors;
    }

    public static void main(String[] args) {
        DirectedGraphLoop_1366_TopoSort_BFS solution = new DirectedGraphLoop_1366_TopoSort_BFS();
//        int[] start = {1, 2, 3};
//        int[] end = {2, 3, 1};
//        //true

        int[] start = {1};
        int[] end = {2};
        //false

        System.out.println(solution.isCyclicGraph(start, end));
    }
}
