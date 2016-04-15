package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.postordertraversal.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/15/16 3:01 PM
 */
public class Solution_Interative_Without_Map {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root ==  null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode previous = null;
        while (stack.size() > 0) {
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
        //expect 231
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);

        //expect 5 13 17 15 10
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(17);

        System.out.println(postorderTraversal(node));
    }
}
