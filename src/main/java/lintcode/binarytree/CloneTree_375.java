package lintcode.binarytree;

import type.TreeNode;

public class CloneTree_375 {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    //Key Idea: DFS with recursive
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null) return null;

        TreeNode newRoot = root;
        newRoot = rec(root, newRoot);

        return newRoot;
    }

    private TreeNode rec(TreeNode node, TreeNode newNode) {
        if (node == null) return null;

        newNode = node;
        if (node.left != null) {
            newNode.left = rec(node.left, newNode.left);
        }
        if (node.right != null) {
            newNode.right = rec(node.right, newNode.right);
        }

        return newNode;
    }
}
