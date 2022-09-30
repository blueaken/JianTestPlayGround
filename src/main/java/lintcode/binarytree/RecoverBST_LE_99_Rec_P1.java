package lintcode.binarytree;

import type.TreeNode;

public class RecoverBST_LE_99_Rec_P1 {
    /*
        P1
        - ref prev notes
        - inorder traverse
        - Time O(N), Space - O(1)
    */

    TreeNode pred = null, x = null, y = null;
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    private void findTwoSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        findTwoSwapped(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return;
            }
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
