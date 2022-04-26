package lintcode.binarytree;

import type.TreeNode;

public class LowestCommonAncestorBST_88 {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     /*
       Ref - https://www.lintcode.com/problem/88/solution/17020
           - https://www.youtube.com/watch?v=13m9ZCB8gjw
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        // 顺序上先判断，防止单节点是A或者B情况
        if (root == A || root == B) {
            return root;
        }
        // 顺序上后判断，防止单节点是A或者B情况
        if (root.left == null && root.right == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
