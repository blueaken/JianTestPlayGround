package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.bstiterator.third;

import type.TreeNode;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 6/29/16 17:22
 */
public class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode current;
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        // write your code here
        this.current = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return stack.size() > 0 || current != null;
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        TreeNode next = stack.pop();
        current = next.right;

        return next;
    }
}
