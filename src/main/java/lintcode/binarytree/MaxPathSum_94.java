package lintcode.binarytree;

import type.TreeNode;

public class MaxPathSum_94 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    //Key Idea: ref previous leetcode Practice on 2016 Feb & https://blog.csdn.net/u010125432/article/details/104653488
    public static int maxPathSum(TreeNode root) {
        // write your code here
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);

        return max[0];
    }

    private static int rec (TreeNode node, int[] max) {
        if (node == null) return 0;

        int maxLeft = rec(node.left, max);
        int maxRight = rec(node.right, max);
        int arch = maxLeft + node.val + maxRight;

        int maxSubTreeWithNode = Math.max(Math.max(maxLeft, maxRight) + node.val, node.val);
        max[0] = Math.max( Math.max(arch, maxSubTreeWithNode), max[0]);

        return maxSubTreeWithNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
