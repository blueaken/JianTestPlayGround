package lintcode.binarytree.treepath;

import type.TreeNode;

public class DiameterOfBinaryTree_LE_543_P1 {
    /*
        ref Huifeng Guan's note
        - diameter is longest left and right path of a node of the tree
        ============
        P1 11.03.2022
        ref 东哥 post - refactor the maxDepth problem with 后序 Traverse
        ============
    */
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        diameter = Math.max(diameter, leftMax + rightMax);

        return 1 + Math.max(leftMax, rightMax);
    }
}
