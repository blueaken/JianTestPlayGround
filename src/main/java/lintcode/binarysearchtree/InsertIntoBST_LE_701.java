package lintcode.binarysearchtree;

import type.TreeNode;

public class InsertIntoBST_LE_701 {
    /*
        11.10.2022
        ref 东哥 post
    */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
