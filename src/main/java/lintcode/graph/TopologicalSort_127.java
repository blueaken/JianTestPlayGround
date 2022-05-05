package lintcode.graph;

import type.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

/*
    DFS solution, ref - https://www.youtube.com/watch?v=ddTC4Zovtbc
    Usage - 用于编译或工作排序系统
*/
public class TopologicalSort_127 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Stack<DirectedGraphNode> stack = new Stack<>();
        Set<DirectedGraphNode> visited = new HashSet<>();
        for (DirectedGraphNode node : graph) {
            if (visited.contains(node)) {
                continue;
            }
            dfs (node, visited, stack);
        }

        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        while (stack.size() > 0) {
            res.add(stack.pop());
        }
        return res;
    }

    private void dfs (DirectedGraphNode node, Set<DirectedGraphNode> visited, Stack<DirectedGraphNode> stack) {
        visited.add(node);
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfs (neighbor, visited, stack);
        }
        stack.add(node);
    }
}
