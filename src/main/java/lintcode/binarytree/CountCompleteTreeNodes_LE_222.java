package lintcode.binarytree;

import type.TreeNode;

public class CountCompleteTreeNodes_LE_222 {
    /**
     11.14.2022
     ref 东哥 post
     */
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;

        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
