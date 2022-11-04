package lintcode.binarytree;

import type.TreeNode;

public class InvertBinaryTree_LE_226 {
    /*
        11.04.2022
        ref东哥post
        - 遍历 & 分解问题都可以工作，这次使用遍历
    */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
