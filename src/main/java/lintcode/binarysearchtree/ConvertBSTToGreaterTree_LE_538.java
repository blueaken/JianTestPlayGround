package lintcode.binarysearchtree;

import type.TreeNode;

public class ConvertBSTToGreaterTree_LE_538 {
    /*
        ref labuladong post, exactly same as 1038
        - 反过来中序遍历BST,形成降序排列
    */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);

        return root;
    }
}
