package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class SumOfRootToLeafBinaryNumbers_LE_1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }

        prevSum = prevSum * 2 + node.val;

        if (node.left == null && node.right == null) {
            return prevSum;
        } else {
            return dfs(node.left, prevSum) + dfs(node.right, prevSum);
        }
    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers_LE_1022 solution = new SumOfRootToLeafBinaryNumbers_LE_1022();
        int[] input = {1,0,1,0,1,0,1};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);
        System.out.println(solution.sumRootToLeaf(root));
    }
}
