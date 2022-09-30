package lintcode.binarytree.lca;

import type.TreeNode;

public class LowestCommonAncestor_LE_236 {
    /*
        notice its diff with 235, not BST
        - 1. one way is to count the path to p, q seperately, then find the first diff node of the 2 lists
        - 2. the other better way is recursively find p & q and count, if count is 2 then return the current node. The trick here is since recursive solution starts from bottom to up, when count is 2 then we find the answer.
        - 3. a better way than above is to recursively search p & q in both sub trees, return the first node have both returned not null. The trick here is similar to above, since the recursive starts from bottom to up, so the 1st non null node is the answer.
    */
    // TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // dfs(root, p, q);
        // return res;

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }

//     private int dfs(TreeNode node, TreeNode p, TreeNode q) {
//         if (node == null) {
//             return 0;
//         }
//         int count = dfs(node.left, p, q) + dfs(node.right, p, q);
//         if (node == p || node == q) {
//             count++;
//         }

//         if (count == 2 && res == null) {
//             res = node;
//         }
//         return count;
//     }
}
