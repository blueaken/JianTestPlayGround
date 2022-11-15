package lintcode.binarytree;

import type.TreeNode;

public class DistributeCoinsInBinaryTree_LE_979 {
    /**
     11.15.2022
     - 涉及subtree使用post order traverse
     - 如果一个节点的硬币个数是 x，无论是移出还是移入，把该节点的硬币个数变成 1 的最少移动次数必然是 abs(x - 1)。
     */
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    // 定义：输入一棵二叉树，返回这棵二叉树中多出的硬币个数，返回负数代表缺少硬币
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        res += Math.abs(left) + Math.abs(right) + (node.val - 1);
        return left + right + (node.val - 1);
    }
}
