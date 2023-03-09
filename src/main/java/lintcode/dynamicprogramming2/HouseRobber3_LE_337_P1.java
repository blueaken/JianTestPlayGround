package lintcode.dynamicprogramming2;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class HouseRobber3_LE_337_P1 {
    /*
        ref labaladong post
        solve with top down DP with mem cache
        ============
        3.9.2023
    */
    Map<TreeNode, Integer> mem = new HashMap<>();
    public int rob(TreeNode root) {
        return dp(root);
    }

    private int dp(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (mem.containsKey(node)) {
            return mem.get(node);
        }

        int noRobCur = dp(node.left) + dp(node.right);
        int robCur = node.val + (node.left == null ? 0 : dp(node.left.left) + dp(node.left.right))
                + (node.right == null ? 0 : dp(node.right.left) + dp(node.right.right));
        int res = Math.max(noRobCur, robCur);
        mem.put(node, res);
        return res;
    }
}
