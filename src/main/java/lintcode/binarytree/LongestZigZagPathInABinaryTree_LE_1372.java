package lintcode.binarytree;

import type.TreeNode;

public class LongestZigZagPathInABinaryTree_LE_1372 {
    /*
        10.27.2022
        ref labaladong 思路
        solve with top down dp (tree traverse)
    */
    int res = 0;
    public int longestZigZag(TreeNode root) {
        dp(root);
        return res;
    }

    //return int array value of max zigzag path starting from left child and max zigzag path starting from right child
    int[] dp(TreeNode root) {
        //base case
        if (root == null) {
            return new int[] {-1, -1};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int leftMaxZigzagPath = left[1] + 1;
        int rightMaxZigzagPath = right[0] + 1;

        res = Math.max(res, Math.max(leftMaxZigzagPath, rightMaxZigzagPath));
        return new int[] {leftMaxZigzagPath, rightMaxZigzagPath};
    }
}
