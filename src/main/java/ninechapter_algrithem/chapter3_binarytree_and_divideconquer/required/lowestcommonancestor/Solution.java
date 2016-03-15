package ninechapter_algrithem.chapter3_binarytree_and_divideconquer.required.lowestcommonancestor;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/28/16 11:51 AM
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }

        //bottom up DC
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return null;
    }
}
