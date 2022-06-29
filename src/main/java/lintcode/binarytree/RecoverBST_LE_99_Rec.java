package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

public class RecoverBST_LE_99_Rec {
    TreeNode x = null, y = null, pred = null;

    /*
    - ref solution link and break the problem into 3 subproblems to solve:
    - 1. inorder traverse and get current list - O(N)
    - 2. find the 2 elements to swap - O(N)
    - 3. recover the tree - O(N)
    - ref: https://leetcode.com/problems/recover-binary-search-tree/solution/
    - Time - O(N), Space - O(N)
        =======================================
    - Merge steps 1 and 2, i.e. identify swapped nodes during the inorder traversal.
    - Swap node values.
    */
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    private void findTwoSwapped(TreeNode root) {
        if (root == null) return;
        findTwoSwapped(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) x = pred;
            else return;
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
        RecoverBST_LE_99_Rec solution = new RecoverBST_LE_99_Rec();
        int[] input = {3,1,4,-999,-999,2}; //case when the 2 swapped node are not adjacent
//        int[] input = {1,3,-999,-999,2}; //case when the 2 swapped node are adjacent
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);
        System.out.println("===========================");
        solution.recoverTree(root);
        TreeNodeUtil.printTree(root);
    }
}
