package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class IsSubTree_LE_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val && isIdentical(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null || a.val != b.val) {
            return false;
        }

        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    public static void main(String[] args) {
        int[] input1 = {1,1};
        TreeNode root = TreeNodeUtil.buildTree(input1);
        TreeNodeUtil.printTree(root);

        int[] input2 = {1};
        type.TreeNode sub = TreeNodeUtil.buildTree(input2);
        TreeNodeUtil.printTree(sub);

        IsSubTree_LE_572 solution = new IsSubTree_LE_572();
        System.out.println(solution.isSubtree(root, sub));
    }
}
