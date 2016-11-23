package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.preordertraversal;

import type.TreeNode;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/27/16 12:21 PM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        rec(root, result);

        return result;
    }

    private static void rec(TreeNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        rec(node.left, result);
        rec(node.right, result);
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);

        //preorder bst is not sorted
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);

        System.out.println(preorderTraversal(node));
    }
}
