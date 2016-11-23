package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.validatebst.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/19/16 8:20 AM
 */
public class Solution_InorderTraverse {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        rec(root, list);
        return isSorted(list);
    }

    private boolean isSorted(List<Integer> list) {
        if (list == null || list.size() < 2) {
            return true;
        }

        int previous = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= previous) {
                return false;
            }
            previous = list.get(i);
        }
        return true;
    }

    private void rec(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        rec(node.left, list);
        list.add(node.val);
        rec(node.right, list);
    }
}
