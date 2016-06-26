package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.inordertraversal.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/15/16 3:01 PM
 */
public class Solution_Iterative {
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
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //expect 213
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);

        //expect 5 10 13 15 17
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(17);

        //expect 231
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.left.right = new TreeNode(3);

        System.out.println(inorderTraversal(node));
    }
}
