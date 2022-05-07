package lintcode.graph;

import java.util.HashSet;
import java.util.Set;

public class DirectedGraphLoop_1366 {
    /**
     * @param start: The start points set
     * @param end: The end points set
     * @return: Return if the graph is cyclic
     */

     /*
        Ref - https://www.youtube.com/watch?v=rKQaZuoUR4M, but TLE
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        Set<Integer> greySet = new HashSet<>();

        //first add all nodes into white set
        for (Integer i : start) {
            whiteSet.add(i);
        }
        for (Integer i : end) {
            whiteSet.add(i);
        }

        while (whiteSet.size() > 0) {
            //pick a random node from white set and dfs
            Integer cur = whiteSet.iterator().next();
            if (dfs(cur, start, end, whiteSet, blackSet, greySet)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Integer cur, int[] start, int[] end, Set<Integer> whiteSet, Set<Integer> blackSet, Set<Integer> greySet) {
        //move cur to grey set from white set then explore it.
        moveNode(cur, whiteSet, greySet);
        //find cur neighbors
        Set<Integer> curNeighbors = new HashSet<>();
        for (int i = 0; i < start.length; i++) {
            if (start[i] == cur) {
                curNeighbors.add(end[i]);
            }
        }
        //then explore each neighbor
        for (Integer i : curNeighbors) {
            //if in black set means already explored then continue;
            if (blackSet.contains(i)) {
                continue;
            }
            //if in grey set means a cycle detected.
            if (greySet.contains(i)) {
                return true;
            }
            //continue explore cur neighbor
            if (dfs(i, start, end, whiteSet, blackSet, greySet)) {
                return true;
            }
        }
        // move cur node from grey set to black set when done exploring.
        moveNode(cur, greySet, blackSet);
        return false;
    }

    private void moveNode(Integer node, Set<Integer> sourceSet, Set<Integer> targetSet) {
        sourceSet.remove(node);
        targetSet.add(node);
    }
}
