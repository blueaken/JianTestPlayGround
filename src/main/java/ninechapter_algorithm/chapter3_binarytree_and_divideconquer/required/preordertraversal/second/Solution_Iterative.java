package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.preordertraversal.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/15/16 2:41 PM
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
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
