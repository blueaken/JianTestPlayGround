package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.convertsortedarraytobst;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/20/16 3:39 PM
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

        return helper(A, 0, A.length - 1);
    }

    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        //top down divide & conquer
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, start, mid - 1);
        node.right = helper(A, mid + 1, end);
        return node;
    }
}
