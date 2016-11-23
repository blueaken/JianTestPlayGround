package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.validatebst;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/28/16 10:04 AM
 */
public class Solution_InOrder_Traversal {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        // write your code here

        //preorder traversal the BST and verify if it is sorted
        List<Integer> list = new ArrayList<>();
        rec(root, list);

        if (list == null) {
            return true;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static void rec(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        rec(node.left, list);
        list.add(node.val);
        rec(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(isValidBST(treeNode));
    }
}
