package lintcode.binarytree.lca;

import type.TreeNode;

public class LowestCommonAncestor2_LE_1644 {
    /**
     11.12.2022
     - similar to 236
     - modify to post traverse to ensure all the tree is traversed before processing find logic, since p or q maybe not in the tree
     */
    boolean foundP = false, foundQ = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);

        return foundP && foundQ ? res : null;
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null) {
            return null;
        }

        //modify to post traverse from 236
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        //mark if p or q is found
        if (root == p || root == q) {
            if (root == p) {
                foundP = true;
            }
            if (root == q) {
                foundQ = true;
            }
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }
}
