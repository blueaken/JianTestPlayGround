package lintcode.binarytree;

import type.TreeNode;

public class MaximumBinaryTree_LE_654 {
    /*
        11.06.2022
        ref 东哥 post
        solve by traverse
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(maxVal);
        node.left = buildTree(nums, start, maxIdx-1);
        node.right = buildTree(nums, maxIdx+1, end);

        return node;
    }
}
