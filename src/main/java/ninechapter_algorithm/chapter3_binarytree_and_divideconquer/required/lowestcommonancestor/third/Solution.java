package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.lowestcommonancestor.third;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/28/16 09:12
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        //left and right both not null
        return root;
    }
}
