package lintcode.binarytree;

import type.TreeNode;

public class LongestZigZagPathInABinaryTree_LE_1372_P1 {
    /*
        10.27.2022
        ref labaladong 思路
        solve with top down dp (tree traverse)
        ================
        P1 11.15.2022
        solve with binary tree 分解问题 with post traverse
        ================
    */
    int res = 0;
    public int longestZigZag(TreeNode root) {
        getPath(root);
        return res;
    }

    //return an array of left and right max zigzag path
    private int[] getPath(TreeNode node) {
        //base case
        if (node == null) {
            return new int[]{-1, -1};
        }

        int[] left = getPath(node.left);
        int[] right = getPath(node.right);

        int leftMaxPath = left[1] + 1;
        int rightMaxPath = right[0] + 1;
        res = Math.max(res, Math.max(leftMaxPath, rightMaxPath));
        return new int[]{leftMaxPath, rightMaxPath};
    }
}
