package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.searchrangeinbst.second;

import type.TreeNode;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 6/29/16 10:02
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
        rec(result, root, k1, k2);
        return result;
    }

    private void rec(ArrayList<Integer> result, TreeNode node, int k1, int k2) {
        if (node == null) {
            return;
        }

        if (node.val > k1) {
            rec(result, node.left, k1, k2);
        }
        if (node.val >= k1 && node.val <= k2) {
            result.add(node.val);
        }
        if (node.val < k2) {
            rec(result, node.right, k1, k2);
        }
    }
}
