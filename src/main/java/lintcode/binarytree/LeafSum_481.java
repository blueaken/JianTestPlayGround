package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class LeafSum_481 {
    /**
     * @param root: the root of the binary tree
     * @return: An integer
     */
    public int leafSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        dfs (root, res);
        return res[0];
    }

    private void dfs (TreeNode node, int[] res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res[0] += node.val;
            return;
        }
        dfs (node.left, res);
        dfs (node.right, res);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        LeafSum_481 solution = new LeafSum_481();
        System.out.println(solution.leafSum(root));
    }
}
