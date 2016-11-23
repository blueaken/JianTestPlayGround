package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.inordertraversal;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/27/16 2:17 PM
 */
public class Solution_Iterative_template {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);

        //inorder bst is sorted
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(17);

        System.out.println(inorderTraversal(node));
    }
}
