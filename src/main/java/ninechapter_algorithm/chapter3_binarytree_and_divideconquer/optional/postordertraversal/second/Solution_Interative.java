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
public class Solution_Interative {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        Map<TreeNode, Boolean> firstVisitedMap = new HashMap<>();
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                firstVisitedMap.put(node, true);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.peek();
                if (firstVisitedMap.get(node)) {
                    firstVisitedMap.put(node, false);
                    node = node.right;
                } else {
                    result.add(node.val);
                    stack.pop();
                    node = null;
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
