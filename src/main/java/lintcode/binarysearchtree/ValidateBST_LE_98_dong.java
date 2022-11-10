package lintcode.binarysearchtree;

import type.TreeNode;

public class ValidateBST_LE_98_dong {
    /*
        - ref Huifeng Guan's note
        - 满足BST的三个条件：
        左子树的最大值小于根节点，且右子树的最小值大于根节点
        左子树也是BST
        右子树也是BST
        在判断第一个条件时，可以根据这个性质：左子树的最大值应该就是左子树最右下角的节点；右子树的最小值应该就是右子树最左下角的节点。

        因此很容易写出递归判断的表达式。
        ========================
        11.10.2022
        redo ref 东哥 post
        ========================
    */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null) {
            if (min.val >= root.val) {
                return false;
            }
        }
        if (max != null) {
            if (max.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
