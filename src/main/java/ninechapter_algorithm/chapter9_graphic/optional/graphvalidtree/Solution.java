package ninechapter_algorithm.chapter9_graphic.optional.graphvalidtree;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 5/9/16 11:33
 */
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (edges.length != n - 1) {
            return false;
        }

        //init parent array to node itself
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Set<Integer> visited = new HashSet<>();
        //find if there is loop
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            boolean firstVisited = visited.contains(first);
            boolean secondVisited = visited.contains(second);
            if (firstVisited && secondVisited) {
                return false;
            } else if (!firstVisited){
              //swap
              int temp = edge[1];
              edge[1] = edge[0];
              edge[0] = temp;
            }

            while (parent[first] != first) {
                first = parent[first];
            }
            while (parent[second] != second) {
                second = parent[second];
            }
            //check if loop exists
            if (first == second) {
                return false;
            }

            parent[edge[1]] = edge[0];
            visited.add(edge[0]);
            visited.add(edge[1]);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int edges[][] = {
                {0, 1},
                {5, 6},
                {6, 7},
                {9, 0},
                {3, 7},
                {4, 8},
                {1, 8},
                {5, 2},
                {5, 3}
        };

        System.out.println(solution.validTree(n, edges));
    }
}
