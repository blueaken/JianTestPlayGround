package lintcode.binarytree.treepath;

import type.TreeNode;

public class DiameterOfBinaryTree_LE_543 {
    /*
        ref Huifeng Guan's note
        - diameter is longest left and right path of a node of the tree
    */
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = longestPath(node.left);
        int right = longestPath(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
