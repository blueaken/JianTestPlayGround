package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.convertsortedarraytobst.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/30/16 08:36
 */
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return rec(A, 0, A.length - 1);
    }

    private TreeNode rec(int[] A, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = rec(A, left, mid - 1);
        node.right = rec(A, mid + 1, right);

        return node;
    }
}
