package lintcode.binarysearchtree;

import type.TreeNode;

public class KthSmallestElementInBST_LE_230 {
    /*
        ref 东哥post
        solve by BST inorder traverse
    */
    int rank = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        traverse(node.left, k);
        rank++;
        if (rank == k) {
            res = node.val;
            return;
        }
        traverse(node.right, k);
    }
}
