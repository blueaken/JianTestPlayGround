package lintcode.binarytree.lca;

import type.TreeNode;

public class FindDistanceInBinaryTree_LE_1740 {
    /**
     11.28.2022
     - LCA type
     - can find LCA first then count the distance to the 2 nodes, but better to solve it in one pass
     - ref https://leetcode.com/problems/find-distance-in-a-binary-tree/solutions/1050033/java-muti-return-value-lca-one-pass/?languageTags=java
     */

    class Pair {
        int count;
        int dis;

        Pair(int c, int d) {
            this.count = c;
            this.dis = d;
        }
    }

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) {
            return 0;
        }
        return lca(root, p, q).dis;
    }

    //solve the lca by post traverse since we need subtree info
    Pair lca(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }

        Pair left = lca(node.left, p, q);
        Pair right = lca(node.right, p, q);

        if (node.val == p || node.val == q) {
            if (left != null || right != null) {
                return left == null ? new Pair(2, right.dis) : new Pair(2, left.dis);
            }
            return new Pair(1, 1);
        }

        if (left != null && right != null) {
            return new Pair(left.count + right.count, left.dis + right.dis);
        }

        if (left != null) {
            if (left.count == 2) {
                return left;
            }
            left.dis++;
            return left;
        }

        if (right != null) {
            if (right.count == 2) {
                return right;
            }
            right.dis++;
            return right;
        }

        return null;
    }
}
