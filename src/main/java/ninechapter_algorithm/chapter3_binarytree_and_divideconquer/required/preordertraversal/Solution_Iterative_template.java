package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.preordertraversal;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/27/16 1:50 PM
 */
public class Solution_Iterative_template {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            while (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);

        System.out.println(preorderTraversal(node));
    }
}
