package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.bstiterator;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/29/16 11:37 AM
 */
public class BSTIterator_Iterative {
    private TreeNode root;
    private List<TreeNode> list = new ArrayList<>();
    private int cur = 0;

    //@param root: The root of binary tree.
    public BSTIterator_Iterative(TreeNode root) {
        // write your code here
        this.root = root;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node);
                node = node.right;
            }
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return list != null && cur < list.size();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        return list.get(cur++);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);

        BSTIterator_Iterative i = new BSTIterator_Iterative(root);
        while (i.hasNext()) {
            System.out.println(i.next().val);
        }
    }
}
