package lintcode.binarytree;

import type.TreeNode;

public class SumNumbers_1353 {
    int ans = 0;
    /**
     * @param root: the root of the tree
     * @return: the total sum of all root-to-leaf numbers
     */
    //Idea: figure out myself, similar to PathSum
    public int sumNumbers(TreeNode root) {
        // write your code here
        if (root == null) {
            return ans;
        }
        dfs (root, 0);
        return ans;
    }

    private void dfs (TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
            return;
        }
        dfs (node.left, sum);
        dfs (node.right, sum);
    }
}
