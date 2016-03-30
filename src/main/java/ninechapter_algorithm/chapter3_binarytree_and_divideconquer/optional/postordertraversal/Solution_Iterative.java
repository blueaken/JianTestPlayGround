package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.postordertraversal;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/27/16 2:22 PM
 */
public class Solution_Iterative {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode previous = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null
            || previous != null && (previous == node.left || previous == node.right)) {
                //如果当前结点没有孩子结点或者孩子节点都已被访问过
                result.add(node.val);
                stack.pop();
                previous = node;
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(postorderTraversal(node));
    }
}
