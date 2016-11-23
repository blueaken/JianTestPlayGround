package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.preordertraversal.third;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 6/26/16 10:05
 */
public class Solution_Iterative {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}
