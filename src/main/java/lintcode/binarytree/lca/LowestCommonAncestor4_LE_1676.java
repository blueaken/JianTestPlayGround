package lintcode.binarytree.lca;

import type.TreeNode;

public class LowestCommonAncestor4_LE_1676 {
    /**
     11.12.2022
     similar to 235, ref 东哥 post
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return null;
        }
        for (TreeNode node : nodes) {
            if (root == node) {
                return node;
            }
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
