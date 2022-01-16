package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class MaxPathSum2_475 {
    int maxSum = Integer.MIN_VALUE;
    /**
     * @param root: the root of binary tree.
     * @return: An integer
     */
    //Idea: 延续PathSum的思路，用全局变量纪录最大值，注意题目要求Path不一定包含叶子节点，而是从Root出发任意Path即可
    public int maxPathSum2(TreeNode root) {
        // write your code here
        if (root == null) {
            return maxSum;
        }
        dfs (root, 0);
        return maxSum;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        sum += node.val;
        maxSum = Math.max(maxSum, sum);

        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    public static void main(String[] args) {
//        int[] input = {-1, 2, 10};
        int[] input = {1,-999,-12};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        MaxPathSum2_475 solution = new MaxPathSum2_475();
        System.out.println(solution.maxPathSum2(root));
    }
}
