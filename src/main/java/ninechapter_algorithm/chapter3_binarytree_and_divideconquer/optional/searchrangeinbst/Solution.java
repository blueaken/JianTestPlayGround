package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.searchrangeinbst;

import type.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: blueaken
 * Date: 4/19/16 4:05 PM
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null || k1 > k2) {
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
                if (node.val >= k1 && node.val <= k2) {
                    result.add(node.val);
                }
                node = node.right;
            }
        }

        return result;
    }
}
