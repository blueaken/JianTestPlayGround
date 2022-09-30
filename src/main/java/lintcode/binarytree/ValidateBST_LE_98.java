package lintcode.binarytree;

import type.TreeNode;

public class ValidateBST_LE_98 {
    /*
        - ref Huifeng Guan's note
        - 满足BST的三个条件：
        左子树的最大值小于根节点，且右子树的最小值大于根节点
        左子树也是BST
        右子树也是BST
        在判断第一个条件时，可以根据这个性质：左子树的最大值应该就是左子树最右下角的节点；右子树的最小值应该就是右子树最左下角的节点。

        因此很容易写出递归判断的表达式。
    */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode node;
        if (root.left != null) {
            node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            if (node.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            if (node.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
