package lintcode.binarytree;


import type.TreeNode;
import util.TreeNodeUtil;

public class RecoverBST_LE_99_Rec_P2 {
    /*
        P1
        - ref prev notes
        - inorder traverse
        - Time O(N), Space - O(1)
        =============
        P2 11.15.2022
        - ref 东哥 post
        - 因为BST，inorder是有序的，使用inorder solve
        =============
    */
    TreeNode prev = null, x = null, y = null;
    public void recoverTree(TreeNode root) {
        inTraverse(root);
        swap(x, y);
    }

    private void inTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inTraverse(node.left);
        //如果中序遍历中发现有序性破坏，纪录出错节点
        if (prev != null && node.val < prev.val) {
            if (x == null) {
                // 纪录第一个出错节点位置prev
                x = prev;
            }
            // 第二个错位节点是最后一个当前node
            y = node;
        }
        prev = node;
        inTraverse(node.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public static void main(String[] args) {
        RecoverBST_LE_99_Rec_P2 solution = new RecoverBST_LE_99_Rec_P2();
//        int[] input = {3,1,4,-999,-999,2}; //case when the 2 swapped node are not adjacent
        int[] input = {1,3,-999,-999,2}; //case when the 2 swapped node are adjacent
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);
        System.out.println("===========================");
        solution.recoverTree(root);
        TreeNodeUtil.printTree(root);
    }
}
