package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.bstiterator.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/19/16 10:48 AM
 */
public class Solution_Iterative {
    private List<TreeNode> list = new ArrayList<>();
    private int index;

    //@param root: The root of binary tree.
    public Solution_Iterative(TreeNode root) {
        // write your code here
        index = 0;
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.size() >0){
                node = stack.pop();
                list.add(node);
                node = node.right;
            }
        }
    }

    private void inorderTraverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        inorderTraverse(node.left, list);
        list.add(node);
        inorderTraverse(node.right, list);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return index < list.size();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        return list.get(index++);

    }
}
