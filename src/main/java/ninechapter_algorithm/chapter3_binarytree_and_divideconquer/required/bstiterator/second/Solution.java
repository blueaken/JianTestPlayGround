package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.bstiterator.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/19/16 10:30 AM
 */
public class Solution {
    private List<TreeNode> list = new ArrayList<>();
    private int index;

    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        // write your code here
        inorderTraverse(root, list);
        index = 0;
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
