package lintcode.dynamicprogramming2;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class HouseRobber3_LE_337 {
    /*
        ref labaladong post
        solve with top down DP with mem cache
    */
    Map<TreeNode, Integer> mem = new HashMap<>();
    public int rob(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        if (mem.containsKey(root)) {
            return mem.get(root);
        }

        //rob case
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        //not rob case
        int undo = (root.left == null ? 0 : rob(root.left)) + (root.right == null ? 0 : rob(root.right));

        //return max
        int res = Math.max(do_it, undo);
        mem.put(root, res);
        return res;
    }
}
