package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.bstiterator;

import type.TreeNode;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/29/16 3:31 PM
 */
public class BSTIterator_NineChapter {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;

    // @param root: The root of binary tree.
    public BSTIterator_NineChapter(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }

    //@return: return next node
    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }

        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;

        return node;
    }
}
