package lintcode.binarytree;

import type.TreeNode;

public class RangeSumOfBST_LE_938 {
    /**
     12.07.2022
     - ref东哥 BST分解问题思路
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        }
    }
}
