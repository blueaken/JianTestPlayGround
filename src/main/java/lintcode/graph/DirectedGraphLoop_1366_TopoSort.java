package lintcode.graph;

import type.DirectedGraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DirectedGraphLoop_1366_TopoSort {
    /**
     * @param start: The start points set
     * @param end: The end points set
     * @return: Return if the graph is cyclic
     */

     /*
        Ref - https://www.youtube.com/watch?v=rKQaZuoUR4M, but TLE, try topo sort solution
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> wholeSet = new HashSet<>();

        //build the node set
        for (Integer i : start) {
            wholeSet.add(i);
        }
        for (Integer i : end) {
            wholeSet.add(i);
        }

        for (Integer node : wholeSet) {
            if (visited.contains(node)) {
                continue;
            }
            dfs (node, start, end, visited, stack);
        }

        //if a cycle exists, topo sort fails to complete the traverse
        return stack.size() != wholeSet.size();
    }

    private void dfs (Integer cur, int[] start, int[] end, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(cur);
        //find cur neighbors
        Set<Integer> curNeighbors = new HashSet<>();
        for (int i = 0; i < start.length; i++) {
            if (start[i] == cur) {
                curNeighbors.add(end[i]);
            }
        }
        for (Integer i : curNeighbors) {
            if (visited.contains(i)) {
                continue;
            }
            dfs (i, start, end, visited, stack);
        }
        stack.add(cur);
    }

}
