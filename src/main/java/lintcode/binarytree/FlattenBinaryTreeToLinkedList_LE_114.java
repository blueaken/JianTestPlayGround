package lintcode.binarytree;

import type.TreeNode;

public class FlattenBinaryTreeToLinkedList_LE_114 {
    /*
        11.04.2022
        ref东哥post
        - if flatten() return type is TreeNode we can traverse by building new Tree
        - since return type is void, need to find a way to convert from the root node itself
        - solve it by 分解子问题方法
    */

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        //先将左右子树拉为直线
        flatten(root.left);
        flatten(root.right);

        //post traverse position

        //再将左右子树合并为直线
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

        return;
    }
}
