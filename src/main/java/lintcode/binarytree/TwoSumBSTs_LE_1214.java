package lintcode.binarytree;

import type.TreeNode;

public class TwoSumBSTs_LE_1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }

        int val = root1.val + root2.val;
        if (val == target) {
            return true;
        }
        if (val > target) {
            return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        } else {
            return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
        }
    }
}
