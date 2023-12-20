package lintcode.graph;

import java.util.*;
import type.TreeNode;
import util.TreeNodeUtil;

public class NumberOfGoodLeafNodesPairs_LE_1530 {
    /**
     12.20.23
     - build a graph first, then dfs traverse
     - ref https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/solutions/1402415/java-graph-building-not-optimal-very-easy/
     */
    int count = 0;
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    Set<TreeNode> leafs = new HashSet<>();
    public int countPairs(TreeNode root, int distance) {
        buildGraph(root, null);

        // dfs each leaf node
        for (TreeNode leaf : leafs) {
            dfs(leaf, distance, new HashSet<>());
        }

        // each good pair is counted twice, the result needs to be divided by 2
        return count/2;
    }

    void dfs(TreeNode node, int distance, Set<TreeNode> visited) {
        if (distance == 0) {
            return;
        }
        visited.add(node);

        for (TreeNode neigh : graph.get(node)) {
            if (visited.contains(neigh)) {
                continue;
            }
            if (leafs.contains(neigh)) {
                count++;
            }
            dfs(neigh, distance-1, visited);
        }
    }

    // build graph via post order traverse
    void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        buildGraph(node.left, node);
        buildGraph(node.right, node);

        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        if (parent != null) {
         if (!graph.containsKey(parent)) {
             graph.put(parent, new ArrayList<>());
         }
         graph.get(parent).add(node);
         graph.get(node).add(parent);
        }

        if (isLeaf(node)) {
            leafs.add(node);
        }

    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        NumberOfGoodLeafNodesPairs_LE_1530 solution = new NumberOfGoodLeafNodesPairs_LE_1530();
        int[] input = {1,2,3,-999,4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);
        int distance = 3;
        // 1

        System.out.println(solution.countPairs(root, distance));
    }
}
