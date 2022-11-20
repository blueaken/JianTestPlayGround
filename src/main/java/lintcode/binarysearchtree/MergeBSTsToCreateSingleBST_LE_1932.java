package lintcode.binarysearchtree;

import type.TreeNode;

import java.util.*;

public class MergeBSTsToCreateSingleBST_LE_1932 {
    /**
     11.20.2022
     ref huifeng guan's code - https://github.com/wisdompeak/LeetCode/tree/master/Tree/1932.Merge-BSTs-to-Create-Single-BST
     - add a little refactors for Java
     */

    Map<Integer, TreeNode> root2Tree = new HashMap<>();
    Set<Integer> subTreeVals = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        for (TreeNode tree : trees) {
            int rootVal = tree.val;
            root2Tree.put(rootVal, tree);
            countSubVals(tree.left);
            countSubVals(tree.right);
        }

        int count = 0;
        TreeNode root = null;
        //there should be only one subtree root val not in the subTreeVals set, which should be the root of the merged tree
        for (TreeNode tree : trees) {
            int rootVal = tree.val;
            if (!subTreeVals.contains(rootVal)) {
                root = tree;
                count++;
            }
        }

        if (count != 1) {
            return null;
        }

        visited.add(root.val);
        boolean ok = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (ok && visited.size() == n) {
            return root;
        }
        return null;
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (val <= min || val >= max) {
            return false;
        }

        if (node.left != null || node.right != null) {
            return dfs(node.left, min, val) && dfs(node.right, val, max);
        }

        //should arrive at leaf node now
        if (root2Tree.containsKey(val)) {
            visited.add(val);
            //in Java needs to use subtree's left & right child to replace original node's left & right to get the tree updated
            TreeNode sub = root2Tree.get(val);
            node.left = sub.left;
            node.right = sub.right;
            return dfs(node.left, min, val) && dfs(node.right, val, max);
        } else {
            return true;
        }
    }

    private void countSubVals(TreeNode node) {
        if (node == null) {
            return;
        }
        subTreeVals.add(node.val);
        countSubVals(node.left);
        countSubVals(node.right);
    }
}
